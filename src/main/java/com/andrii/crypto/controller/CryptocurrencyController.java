package com.andrii.crypto.controller;

import com.andrii.crypto.model.Cryptocurrency;
import com.andrii.crypto.service.CryptocurrencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("/cryptocurrencies")
public class CryptocurrencyController {

    private final Logger log = LoggerFactory.getLogger(CryptocurrencyController.class);

    @Autowired
    private CryptocurrencyService cryptocurrencyService;

    @RequestMapping(method = RequestMethod.GET, value = "/minprice")
    public Cryptocurrency getWithMinPrice(@RequestParam String name) {
        try {
            return cryptocurrencyService.getWithMinPrice(name);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong...", e);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/maxprice")
    public Cryptocurrency getWithMaxPrice(@RequestParam String name) {
        try {
            return cryptocurrencyService.getWithMaxPrice(name);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong...", e);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Cryptocurrency> getAllCryptoPage(
            @RequestParam("name") String name,
            @RequestParam(defaultValue = "0", name = "page") int page,
            @RequestParam(defaultValue = "10", name = "size") int size) {
    try {
        return cryptocurrencyService.getAllCryptoPage(name, page, size);
    } catch (Exception e) {
        log.error(e.getMessage());
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong...", e);
    }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/csv")
    public void generateCsv(HttpServletResponse servletResponse) {
        try {
            servletResponse.setContentType("text/csv");
            servletResponse.addHeader("Content-Disposition", "attachment; filename=\"cryptocurrencies.csv\"");
            cryptocurrencyService.writeToCsv(servletResponse.getWriter());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong...", e);
        }
    }
}
