package com.example.tom.tradeapp;

import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tom.tradeapp.ApiClasses.DealsAPI;

import java.util.List;
import java.util.Objects;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    public List<DealsAPI> deals;

    public RecyclerAdapter(List<DealsAPI> deals){
        this.deals = deals;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MyViewHolder holder, int position) {
            holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return deals.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView userSell, userBuy, amount, price, sum;

        public MyViewHolder(View itemView) {
            super(itemView);

            userBuy = itemView.findViewById(R.id.usernameTvBuy);
            userSell = itemView.findViewById(R.id.usernameTvSell);
            amount = itemView.findViewById(R.id.amountTvSell);
            price = itemView.findViewById(R.id.priceTvBuy);
            sum = itemView.findViewById(R.id.sumTv);

        }
        public void bind(int pos){
            if (2 * pos + 1 < getItemCount()){
                if(Objects.equals(deals.get(2 * pos).getPubDate(), deals.get(2 * pos + 1).getPubDate())){
                    amount.setFilters(new InputFilter[]{new InputFilter.LengthFilter(deals.get(2 * pos).getAmountTrade().indexOf('.') + 3)});
                    price.setFilters(new InputFilter[]{new InputFilter.LengthFilter(deals.get(2 * pos).getCoinPrice().indexOf('.') + 3)});
                    sum.setFilters(new InputFilter[]{new InputFilter.LengthFilter(deals.get(2 * pos).getAmountBase().indexOf('.') + 3)});
                    if(Objects.equals(deals.get(2 * pos).getDealType(), "buy")){
                        userBuy.setText(deals.get(2 * pos).getUsername());
                        userSell.setText(deals.get(2 * pos + 1).getUsername());
                    } else {
                        userBuy.setText(deals.get(2 * pos + 1).getUsername());
                        userSell.setText(deals.get(2 * pos).getUsername());
                    }
                    amount.setText(deals.get(2 * pos).getAmountTrade());
                    price.setText(deals.get(2 * pos).getCoinPrice());
                    sum.setText(deals.get(2 * pos).getAmountBase());

            }



            }
        }
    }
}
