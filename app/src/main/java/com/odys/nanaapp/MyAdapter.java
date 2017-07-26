package com.odys.nanaapp;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private static String[] nameDataSet;
    private static String[] descriptionDataSet;
    private static int[] photoDataSet;


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public TextView memberName;
        public TextView memberDescription;
        public ImageView memberPhoto;

        public MyViewHolder(View v) {
            super(v);

            cardView = (CardView) v.findViewById(R.id.card_view);
            memberName = (TextView) v.findViewById(R.id.member_name);
            memberDescription = (TextView) v.findViewById(R.id.member_description);
            memberPhoto = (ImageView) v.findViewById(R.id.member_photo);

            final boolean cardSide[] = new boolean[nameDataSet.length];

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!cardSide[getAdapterPosition()]) {
                        memberName.setTextColor(ContextCompat.getColor(v.getContext(), R.color.colorPrimary));
                        cardSide[getAdapterPosition()]=true;
                        memberPhoto.setVisibility(View.INVISIBLE);
                        memberDescription.setVisibility(View.VISIBLE);
                    } else {
                        memberName.setTextColor(ContextCompat.getColor(v.getContext(), android.R.color.tab_indicator_text));
                        cardSide[getAdapterPosition()]=false;
                        memberPhoto.setVisibility(View.VISIBLE);
                        memberDescription.setVisibility(View.INVISIBLE);
                    }
                }
            });
        }
    }

    public MyAdapter(String[] nameSet, String[] descriptionSet, int[] photoSet) {
        nameDataSet = nameSet;
        descriptionDataSet = descriptionSet;
        photoDataSet = photoSet;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.memberName.setText(nameDataSet[position]);
        holder.memberDescription.setText(descriptionDataSet[position]);
        holder.memberPhoto.setImageResource(photoDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return nameDataSet.length;
    }


}
