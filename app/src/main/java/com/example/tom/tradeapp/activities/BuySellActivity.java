package com.example.tom.tradeapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tom.tradeapp.ApiClasses.ApiClient;
import com.example.tom.tradeapp.ApiClasses.BuySellRequestAPI;
import com.example.tom.tradeapp.ApiClasses.DealsAPI;
import com.example.tom.tradeapp.R;
import com.example.tom.tradeapp.adapters.BuySellRequestRA;
import com.example.tom.tradeapp.adapters.DealsRA;
import com.example.tom.tradeapp.interfaces.BtcTradeInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Tom on 26.12.2017.
 */

public class BuySellActivity extends AppCompatActivity{

    public RecyclerView.LayoutManager layoutManager;
    public RecyclerView recyclerView;
    public BtcTradeInterface btcTrade;
    public Spinner spinner;
    String chose;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buysell_request);


        recyclerView = findViewById(R.id.recyclerViewBuySellRequest);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        spinner = findViewById(R.id.spinnerBuySell);


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

                Call<List<BuySellRequestAPI>> buyDeals = btcTrade.request(chose);

                buyDeals.enqueue(new Callback<List<BuySellRequestAPI>>() {

                    @Override
                    public void onResponse(Call<List<BuySellRequestAPI>> call, Response<List<BuySellRequestAPI>> response) {
//GET BAD GATEWAY 502 WTF????
                        if(response.isSuccessful()) {
                            Toast.makeText(BuySellActivity.this, "Success recycler", Toast.LENGTH_SHORT).show();
                            recyclerView.setAdapter(new BuySellRequestRA(response.body()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<BuySellRequestAPI>> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
