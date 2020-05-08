package com.example.currencyapp.api.services;


import com.example.currencyapp.api.ApiEndPoints;
import com.example.currencyapp.models.CurrencyListResponse;
import com.example.currencyapp.models.HistoryRatesResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * @author zoubair
 * @since 07/05/20
 */
public interface ClientService {


    @Headers("Content-Type: application/x-www-form-urlencoded")
    @GET(ApiEndPoints.BASE_CURRENCY_LIST)
    Observable<CurrencyListResponse> getCurrencyList();

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @GET(ApiEndPoints.HISTORY_RATE_LIST)
    Observable<HistoryRatesResponse> getHistoryRates(@Query("symbols") String symbol, @Query("start_at") String startDate, @Query("end_at") String endDate);


}
