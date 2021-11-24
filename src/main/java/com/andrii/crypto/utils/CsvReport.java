package com.andrii.crypto.utils;

public class CsvReport {

    private String name;
    private String maxPrice;
    private String minPrice;

    public CsvReport() {
    }

    public CsvReport(String name, String maxPrice, String minPrice) {
        this.name = name;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }
}
