package com.example.currencyapp.api;


import com.example.currencyapp.models.CurrencyListResponse;
import com.example.currencyapp.models.HistoryRatesResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


/**
 * @author zoubair
 * @since 07/05/20
 */
@Singleton
public class DataManager {

    private final BaseApiManager baseApiManager;

    @Inject
    public DataManager(BaseApiManager baseApiManager) {
        this.baseApiManager = baseApiManager;
    }

    public Observable<CurrencyListResponse> getCurrencyListCall() {
        return baseApiManager.getClientsApi().getCurrencyList();
    }

    public Observable<HistoryRatesResponse> getCurrencyHistoryRates(String symbol, String startDate, String endDate) {
        return baseApiManager.getClientsApi().getHistoryRates(symbol, startDate, endDate);
    }
}
