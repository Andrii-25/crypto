package com.andrii.crypto.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PriceService {

    private final HttpHeaders headers = new HttpHeaders();
    private final RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<String> getLastPrices(String symbol1, String symbol2) {
        String url = "https://cex.io/api/last_price/" + symbol1 + "/" + symbol2;
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }

    private ResponseEntity<String> getPriceBtcUsd() {
        return getLastPrices("BTC", "USD");
    }

    private ResponseEntity<String> getPriceEthUsd() {
        return getLastPrices("ETH", "USD");
    }

    private ResponseEntity<String> getPriceXrpUsd() {
        return getLastPrices("XRP", "USD");
    }

    public List<JsonObject> getAllPrices() {
        List<JsonObject> prices = new ArrayList<>();
        JsonObject btcUsd = new Gson().fromJson(getPriceBtcUsd().getBody(), JsonObject.class);
        JsonObject ethUsd = new Gson().fromJson(getPriceEthUsd().getBody(), JsonObject.class);
        JsonObject xrpUsd = new Gson().fromJson(getPriceXrpUsd().getBody(), JsonObject.class);
        prices.add(btcUsd);
        prices.add(ethUsd);
        prices.add(xrpUsd);
        return prices;
    }
}
