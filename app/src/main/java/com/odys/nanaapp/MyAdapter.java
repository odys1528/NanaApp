package com.odys.nanaapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private static String[] nameDataSet;
    private static String[] descriptionDataSet;
    private static int[] photoDataSet;


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public TextView memberName;
        public ImageView memberPhoto;

        public CardView cardView2;
        public TextView memberName2;
        public TextView memberDescription;

        ViewFlipper viewFlipper;

        public MyViewHolder(View v) {
            super(v);

            cardView = (CardView) v.findViewById(R.id.card_view);
            cardView2 = (CardView) v.findViewById(R.id.card_view2);
            memberName = (TextView) v.findViewById(R.id.member_name);
            memberName2 = (TextView) v.findViewById(R.id.member_name2);
            memberDescription = (TextView) v.findViewById(R.id.member_description);
            memberPhoto = (ImageView) v.findViewById(R.id.member_photo);

            viewFlipper = (ViewFlipper) v.findViewById(R.id.view_flipper);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewFlipper.setDisplayedChild(1);
                }
            });

            cardView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewFlipper.setDisplayedChild(0);
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
        holder.memberName2.setText(nameDataSet[position]);
        holder.memberDescription.setText(descriptionDataSet[position]);
        holder.memberPhoto.setImageResource(photoDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return nameDataSet.length;
    }


}
