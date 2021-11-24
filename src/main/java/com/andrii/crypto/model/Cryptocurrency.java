package com.andrii.crypto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cryptocurrencies")
public class Cryptocurrency {

    @Id
    private int id;

    private String curr1;

    private String curr2;

    private String lprice;

    private String createdAt;

    public Cryptocurrency() {
    }

    public Cryptocurrency(String curr1, String curr2, String lprice, String createdAt) {
        this.curr1 = curr1;
        this.curr2 = curr2;
        this.lprice = lprice;
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurr1() {
        return curr1;
    }

    public void setCurr1(String curr1) {
        this.curr1 = curr1;
    }

    public String getCurr2() {
        return curr2;
    }

    public void setCurr2(String curr2) {
        this.curr2 = curr2;
    }

    public String getLprice() {
        return lprice;
    }

    public void setLprice(String lprice) {
        this.lprice = lprice;
    }
}
