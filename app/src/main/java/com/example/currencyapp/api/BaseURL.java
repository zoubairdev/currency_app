package com.example.currencyapp.api;

/**
 * @author zoubair
 * @since 07/05/20
 */

public class BaseURL {

    public static final String API_ENDPOINT = "api.exchangeratesapi.io";
    public static final String PROTOCOL_HTTPS = "https://";

    private String url;

    public String getUrl() {
        if (url == null) {
            return PROTOCOL_HTTPS + API_ENDPOINT;
        }
        return url;
    }
}
