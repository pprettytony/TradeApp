package com.example.tom.tradeapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tom.tradeapp.ApiClasses.BuyDeals;

import java.util.List;

/**
 * Created by Tom on 09.12.2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    public List<BuyDeals> deals;

    public RecyclerAdapter(List<BuyDeals> deals){
        this.deals = deals;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MyViewHolder holder, int position) {
        holder.tv.setText(deals.get(position).getCoinPrice());
    }

    @Override
    public int getItemCount() {
        return deals.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv = itemView.findViewById(R.id.priceTv);
        }
    }
}
