package com.example.tom.tradeapp;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tom on 09.12.2017.
 */

public class ApiClient {

    public static final String BASE_URL = "https://btc-trade.com.ua/api/deals/";

    public static Retrofit retrofit = null;

    public static Retrofit getApiClient(){

        if(retrofit == null){

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
