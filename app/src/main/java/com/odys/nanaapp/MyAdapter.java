package com.odys.nanaapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[] dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public TextView textView;
        public MyViewHolder(View v) {
            super(v);

            cardView = (CardView) v.findViewById(R.id.card_view);
            textView = (TextView) v.findViewById(R.id.memberName);
        }
    }

    public MyAdapter(String[] myDataSet) {
        dataSet = myDataSet;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(dataSet[position]);
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }


}
