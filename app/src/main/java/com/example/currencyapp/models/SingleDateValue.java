package com.example.currencyapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class SingleDateValue implements Comparable<SingleDateValue> {

    @SerializedName("date")
    Date date;
    @SerializedName("rate")
    String rate;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }


    @Override
    public int compareTo(SingleDateValue o) {
        return getDate().compareTo(o.getDate());
    }
}
