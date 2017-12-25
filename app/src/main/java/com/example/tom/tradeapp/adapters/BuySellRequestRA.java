package com.example.tom.tradeapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tom.tradeapp.ApiClasses.BuySellRequestAPI;
import com.example.tom.tradeapp.R;

import java.util.List;


public class BuySellRequestRA extends RecyclerView.Adapter<BuySellRequestRA.BuySellViewHolder> {

    List<BuySellRequestAPI> requests;

    public BuySellRequestRA(List<BuySellRequestAPI> requests) {
        this.requests = requests;
    }

    @Override
    public BuySellViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.buy_sell_row_item,parent,false);
        return new BuySellRequestRA.BuySellViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BuySellViewHolder holder, int position) {
        holder.bind(position);
    }


    @Override
    public int getItemCount() {
        return requests.size();
    }

    public class BuySellViewHolder extends RecyclerView.ViewHolder {

        TextView price, amount, summary;
        public BuySellViewHolder(View itemView) {
            super(itemView);

            price = itemView.findViewById(R.id.priceTvBuyRequest);
            amount = itemView.findViewById(R.id.amountTvBuyRequest);
            summary = itemView.findViewById(R.id.sumTvBuyRequest);
        }
        public void bind(int pos){
            price.setText(requests.get(pos).getRequestList().getPrice());
            amount.setText(requests.get(pos).getRequestList().getCurrenceTrade());
            summary.setText(requests.get(pos).getRequestList().getCurrencyBase());
        }
    }
}
