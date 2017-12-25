package com.example.tom.tradeapp.ApiClasses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tom on 14.12.2017.
 */

public class RequestListAPI {

    @SerializedName("currency_trade")
    private String currenceTrade;

    @SerializedName("price")
    private String price;

    @SerializedName("currency_base")
    private String currencyBase;

    public String getCurrenceTrade() {
        return currenceTrade;
    }

    public String getPrice() {
        return price;
    }

    public String getCurrencyBase() {
        return currencyBase;
    }
}
