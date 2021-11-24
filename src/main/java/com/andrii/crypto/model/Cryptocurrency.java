package com.andrii.crypto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cryptocurrencies")
public class Cryptocurrency {

    @Id
    private int id;

    private String name;

    private String abbreviated;

    private int price;

    private String currencyPrice;

    public Cryptocurrency() {
    }

    public Cryptocurrency(String name, String abbreviated, int price, String currencyPrice) {
        this.name = name;
        this.abbreviated = abbreviated;
        this.price = price;
        this.currencyPrice = currencyPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviated() {
        return abbreviated;
    }

    public void setAbbreviated(String abbreviated) {
        this.abbreviated = abbreviated;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrencyPrice() {
        return currencyPrice;
    }

    public void setCurrencyPrice(String currencyPrice) {
        this.currencyPrice = currencyPrice;
    }
}
