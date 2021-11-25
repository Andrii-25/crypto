package com.andrii.crypto.service;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
class PriceServiceTest {

    PriceService priceService = new PriceService();

    @Test
    void getLastPrices() {
        ResponseEntity<String> res = priceService.getLastPrices("BTC", "USD");
        Assertions.assertEquals(200, res.getStatusCodeValue());
    }

    @Test
    void getAllPrices() {
        List<JsonObject> prices;
        prices = priceService.getAllPrices();
        Assertions.assertFalse(prices.isEmpty());

    }
}
