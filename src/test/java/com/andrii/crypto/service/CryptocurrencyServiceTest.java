package com.andrii.crypto.service;

import com.andrii.crypto.model.Cryptocurrency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class CryptocurrencyServiceTest {

    @Autowired
    CryptocurrencyService cryptocurrencyService = new CryptocurrencyService();

    @Test
    void getWithMinPrice() {
        Cryptocurrency crypto = cryptocurrencyService.getWithMinPrice("BTC");
        Assertions.assertNotNull(crypto);
    }

    @Test
    void getWithMaxPrice() {
        Cryptocurrency crypto = cryptocurrencyService.getWithMaxPrice("BTC");
        Assertions.assertNotNull(crypto);
    }

    @Test
    void getAllCryptoPage() {
        List<Cryptocurrency> list = cryptocurrencyService.getAllCryptoPage("BTC", 0, 10);
        Assertions.assertFalse(list.isEmpty());
    }
}
