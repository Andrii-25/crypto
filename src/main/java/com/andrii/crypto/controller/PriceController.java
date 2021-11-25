package com.andrii.crypto.controller;

import com.andrii.crypto.service.PriceService;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class PriceController {

    private final Logger log = LoggerFactory.getLogger(PriceController.class);

    @Autowired
    private PriceService priceService;

    @RequestMapping(method = RequestMethod.GET, value = "/prices/{symbol1}/{symbol2}")
    public ResponseEntity<String> getLastPrices(@PathVariable String symbol1, @PathVariable String symbol2) {
        try {
            return priceService.getLastPrices(symbol1, symbol2);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong...", e);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all_prices")
    public List<JsonObject> getAllPrices() {
        try {
            return priceService.getAllPrices();
        } catch(Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong...", e);
        }
    }
}
