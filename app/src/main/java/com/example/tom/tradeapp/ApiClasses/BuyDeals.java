package com.example.tom.tradeapp.ApiClasses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tom on 09.12.2017.
 */

public class BuyDeals {

    @SerializedName("price")
    private String CoinPrice;

    public String getCoinPrice() {
        return CoinPrice;
    }

}
