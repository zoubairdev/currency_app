package com.example.currencyapp.api;


import com.example.currencyapp.api.services.ClientService;
import com.google.gson.GsonBuilder;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author zoubair
 * @since 07/05/20
 */
public class BaseApiManager {

    private static Retrofit retrofit;
    private static ClientService clientsApi;


    @Inject
    public BaseApiManager() {
        createService();
    }

    private static void init() {
        clientsApi = createApi(ClientService.class);
    }

    private static <T> T createApi(Class<T> clazz) {
        return retrofit.create(clazz);
    }


    public static void createService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(new BaseURL().getUrl())
                .client(new SelfServiceOkHttpClient().getMifosOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                        .setLenient()
                        .create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        init();
    }


    public ClientService getClientsApi() {
        return clientsApi;
    }
}
