package com.example.currencyapp.views;

import com.example.currencyapp.models.Currency;
import com.example.currencyapp.models.SingleDateValue;

import java.util.List;

public interface CurrencyView extends MVPView {

    default void showError(String errorMessage) {
    }

    default void currencyListReady(List<Currency> currencies) {
    }

    default void currencyHistoryRatesReady(List<SingleDateValue> historyRates) {
    }

}
