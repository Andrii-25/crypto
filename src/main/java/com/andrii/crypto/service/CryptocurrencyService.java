package com.andrii.crypto.service;

import com.andrii.crypto.model.Cryptocurrency;
import com.andrii.crypto.repository.CryptocurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CryptocurrencyService {

    private final HttpHeaders headers = new HttpHeaders();
    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private CryptocurrencyRepository cryptocurrencyRepository;

    @Scheduled(fixedRate = 10000)
    public void saveCryptocurrencyPricesToDb() {
        Cryptocurrency[] cryptocurrencies = getCryptoCurrenciesPrices();
        for (Cryptocurrency cryptocurrency : cryptocurrencies) {
            cryptocurrency.setId(getRandomInt());
            cryptocurrency.setCreatedAt(getCurrentDate());
            cryptocurrencyRepository.insert(cryptocurrency);
        }
    }

    private Cryptocurrency[] getCryptoCurrenciesPrices() {
        String BASE_URL = "http://localhost:8080/";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(BASE_URL + "all_prices", Cryptocurrency[].class);
    }

    private String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    private int getRandomInt() {
        return ThreadLocalRandom.current().nextInt(0, 100000);
    }
}
