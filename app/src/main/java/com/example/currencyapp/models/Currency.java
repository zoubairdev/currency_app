package com.example.currencyapp.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Currency implements Serializable {


    @SerializedName("symbol")
    String symbol;
    @SerializedName("rate")
    String rate;


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
