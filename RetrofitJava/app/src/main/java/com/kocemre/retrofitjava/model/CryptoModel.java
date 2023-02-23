package com.kocemre.retrofitjava.model;

import com.google.gson.annotations.SerializedName;

public class CryptoModel {
    @SerializedName("currency")
    String currency;
    @SerializedName("price")
    String price;

    public String getCurrency() {
        return currency;
    }

    public String getPrice() {
        return price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
