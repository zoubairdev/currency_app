package com.example.currencyapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class HistoryRatesResponse {
    @SerializedName("rates")
    private Map<String, Map<String, String>> rates;

    @SerializedName("start_at")
    private String startDate;
    @SerializedName("end_at")
    private String endDate;
    @SerializedName("base")
    private String base;

    public Map<String, Map<String, String>> getRates() {
        return rates;
    }

    public void setRates(Map<String, Map<String, String>> rates) {
        this.rates = rates;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
}
