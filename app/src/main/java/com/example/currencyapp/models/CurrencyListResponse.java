package com.example.currencyapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class CurrencyListResponse {

    @SerializedName("rates")
    private Map<String, String> rates;
    @SerializedName("base")
    String base;
    @SerializedName("date")
    String date;

    public Map<String, String> getRates() {
        return rates;
    }

    public void setRates(Map<String, String> rates) {
        this.rates = rates;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
