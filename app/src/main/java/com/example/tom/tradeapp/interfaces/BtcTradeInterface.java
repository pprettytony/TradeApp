package com.example.tom.tradeapp.interfaces;

import com.example.tom.tradeapp.ApiClasses.BuyDeals;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Tom on 09.12.2017.
 */

public interface BtcTradeInterface {
    @GET("{coin}")
    Call<List<BuyDeals>> deals(@Path("coin") String coinName);
}
