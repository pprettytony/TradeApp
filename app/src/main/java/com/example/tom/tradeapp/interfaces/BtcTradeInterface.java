package com.example.tom.tradeapp.interfaces;

import com.example.tom.tradeapp.ApiClasses.BuySellRequestAPI;
import com.example.tom.tradeapp.ApiClasses.DealsAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Tom on 09.12.2017.
 */

public interface BtcTradeInterface {
    @GET("deals/{coin}")
    Call<List<DealsAPI>> deals(@Path("coin") String coinName);

    @GET("trades/buy/{coin}")
    Call<List<BuySellRequestAPI>> request(@Path("coin") String coinName);
}
