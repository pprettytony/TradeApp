package com.example.tom.tradeapp.ApiClasses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tom on 09.12.2017.
 */

public class DealsAPI {

    @SerializedName("amnt_base")
    private String AmountBase;

    @SerializedName("amnt_trade")
    private String AmountTrade;

    @SerializedName("price")
    private String CoinPrice;

    @SerializedName("pub_date")
    private String PubDate;

    @SerializedName("user")
    private String Username;

    @SerializedName("type")
    private String DealType;

    public String getAmountBase() {
        return AmountBase;
    }

    public String getAmountTrade() {
        return AmountTrade;
    }

    public String getPubDate() {
        return PubDate;
    }

    public String getUsername() {
        return Username;
    }

    public String getDealType() {
        return DealType;
    }

    public String getCoinPrice() {
        return CoinPrice;
    }

}
