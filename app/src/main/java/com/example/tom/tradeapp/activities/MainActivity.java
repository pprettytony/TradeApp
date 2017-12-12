package com.example.tom.tradeapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.tom.tradeapp.ApiClasses.BuyDeals;
import com.example.tom.tradeapp.ApiClient;
import com.example.tom.tradeapp.R;
import com.example.tom.tradeapp.RecyclerAdapter;
import com.example.tom.tradeapp.interfaces.BtcTradeInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    public RecyclerView.LayoutManager layoutManager;
    public RecyclerView recyclerView;
    public BtcTradeInterface btcTrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        tv = findViewById(R.id.priceTv);

        btcTrade = ApiClient.getApiClient().create(BtcTradeInterface.class);

        Call<List<BuyDeals>> buyDeals = btcTrade.deals("krb_uah");

        buyDeals.enqueue(new Callback<List<BuyDeals>>() {
            @Override
            public void onResponse(Call<List<BuyDeals>> call, Response<List<BuyDeals>> response) {
                if(response.isSuccessful()) {
                    recyclerView.setAdapter(new RecyclerAdapter(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<BuyDeals>> call, Throwable t) {

            }
        });


    }
}
