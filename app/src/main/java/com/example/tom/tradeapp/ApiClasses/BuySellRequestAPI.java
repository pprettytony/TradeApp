package com.example.tom.tradeapp.ApiClasses;

import android.app.DownloadManager;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tom on 14.12.2017.
 */

public class BuySellRequestAPI {

    public String getMinPrice() {
        return minPrice;
    }

    public RequestListAPI getRequestList() {
        return requestList;
    }

    public String getOrderSum() {
        return orderSum;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    @SerializedName("min_price")
    private String minPrice;

    @SerializedName("list")
    private RequestListAPI requestList;

    @SerializedName("order_sum")
    private String orderSum;

    @SerializedName("max_price")
    private String maxPrice;

}
