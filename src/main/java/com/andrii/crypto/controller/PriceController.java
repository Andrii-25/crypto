package com.andrii.crypto.controller;

import com.andrii.crypto.service.PriceService;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PriceController {

    @Autowired
    private PriceService priceService;

    @RequestMapping(method = RequestMethod.GET, value = "/prices/{symbol1}/{symbol2}")
    public ResponseEntity<String> getLastPrices(@PathVariable String symbol1, @PathVariable String symbol2) {
            return priceService.getLastPrices(symbol1, symbol2);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all_prices")
    public List<JsonObject> getAllPrices() {
        return priceService.getAllPrices();
    }
}
