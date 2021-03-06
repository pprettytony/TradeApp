package com.example.tom.tradeapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.tom.tradeapp.ApiClasses.DealsAPI;
import com.example.tom.tradeapp.ApiClasses.ApiClient;
import com.example.tom.tradeapp.R;
import com.example.tom.tradeapp.adapters.DealsRA;
import com.example.tom.tradeapp.interfaces.BtcTradeInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DealsActivity extends AppCompatActivity{

    public RecyclerView.LayoutManager layoutManager;
    public RecyclerView recyclerView;
    public BtcTradeInterface btcTrade;
    public Spinner spinner;
    String chose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deals);

        recyclerView = findViewById(R.id.recyclerViewDeals);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        spinner = findViewById(R.id.spinner);


        btcTrade = ApiClient.getApiClient().create(BtcTradeInterface.class);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        chose = "krb_uah";
                        break;
                    case 1:
                        chose = "btc_uah";
                        break;
                    case 2:
                        chose = "eth_uah";
                        break;
                    case 3:
                        chose = "doge_uah";
                        break;
                    case 4:
                        chose = "xmr_uah";
                        break;
                }

                Call<List<DealsAPI>> buyDeals = btcTrade.deals(chose);

                buyDeals.enqueue(new Callback<List<DealsAPI>>() {
                    @Override
                    public void onResponse(Call<List<DealsAPI>> call, Response<List<DealsAPI>> response) {
                        if(response.isSuccessful()) {
                            recyclerView.setAdapter(new DealsRA(response.body()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<DealsAPI>> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
