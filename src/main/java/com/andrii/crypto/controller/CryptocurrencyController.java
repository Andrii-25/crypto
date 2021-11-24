package com.andrii.crypto.controller;

import com.andrii.crypto.service.CryptocurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CryptocurrencyController {

    @Autowired
    private CryptocurrencyService cryptocurrencyService;

}
