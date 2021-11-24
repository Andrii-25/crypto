package com.andrii.crypto.service;

import com.andrii.crypto.model.Cryptocurrency;
import com.andrii.crypto.repository.CryptocurrencyRepository;
import com.andrii.crypto.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class CryptocurrencyService {

    private final HttpHeaders headers = new HttpHeaders();
    private final RestTemplate restTemplate = new RestTemplate();
    private final Utils utils = new Utils();

    @Autowired
    private CryptocurrencyRepository cryptocurrencyRepository;

    @Scheduled(fixedRate = 10000)
    public void saveCryptocurrencyPricesToDb() {
        Cryptocurrency[] cryptocurrencies = getCryptoCurrenciesPrices();
        for (Cryptocurrency cryptocurrency : cryptocurrencies) {
            cryptocurrency.setId(utils.getRandomInt());
            cryptocurrency.setCreatedAt(utils.getCurrentDate());
            cryptocurrencyRepository.insert(cryptocurrency);
        }
    }

    private List<Cryptocurrency> getRecordsByCryptoName(String name) {
        return cryptocurrencyRepository.findByCurr1(name);
    }

    public Cryptocurrency getWithMinPrice(String name) {
        List<Cryptocurrency> list = getRecordsByCryptoName(name);
        return list
                .stream()
                .min(Comparator
                        .comparing(Cryptocurrency::getLprice))
                .orElseThrow(NoSuchElementException::new);
    }

    public Cryptocurrency getWithMaxPrice(String name) {
        List<Cryptocurrency> list = getRecordsByCryptoName(name);
        return list
                .stream()
                .max(Comparator
                        .comparing(Cryptocurrency::getLprice))
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Cryptocurrency> getAllCryptoPage(String name, int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Cryptocurrency> pageCrypto;
        pageCrypto = cryptocurrencyRepository.findByCurr1(name, paging);
        return pageCrypto.getContent();
    }

    private Cryptocurrency[] getCryptoCurrenciesPrices() {
        String BASE_URL = "http://localhost:8080/";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(BASE_URL + "all_prices", Cryptocurrency[].class);
    }
}
