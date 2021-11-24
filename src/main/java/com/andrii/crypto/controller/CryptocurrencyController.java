package com.andrii.crypto.controller;

import com.andrii.crypto.model.Cryptocurrency;
import com.andrii.crypto.service.CryptocurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cryptocurrencies")
public class CryptocurrencyController {

    @Autowired
    private CryptocurrencyService cryptocurrencyService;

    @RequestMapping(method = RequestMethod.GET, value = "/minprice")
    public Cryptocurrency getWithMinPrice(@RequestParam String name) {
        return cryptocurrencyService.getWithMinPrice(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/maxprice")
    public Cryptocurrency getWithMaxPrice(@RequestParam String name) {
        return cryptocurrencyService.getWithMaxPrice(name);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Cryptocurrency> getAllCryptoPage(
            @RequestParam("name") String name,
            @RequestParam(defaultValue = "0", name = "page") int page,
            @RequestParam(defaultValue = "10", name = "size") int size) {

        return cryptocurrencyService.getAllCryptoPage(name, page, size);
    }
}
