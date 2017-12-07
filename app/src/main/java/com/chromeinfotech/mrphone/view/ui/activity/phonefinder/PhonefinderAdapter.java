package com.chromeinfotech.mrphone.view.ui.activity.phonefinder;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chromeinfotech.mrphone.R;

import java.util.ArrayList;

/**
 * Created by user on 5/9/17.
 */

public class PhonefinderAdapter extends RecyclerView.Adapter<PhonefinderAdapter.ViewHolder> {
    // Set numbers of Tiles in RecyclerView.
    private static final int LENGTH = 14;

    private final String[] mPlaces;
    private final Drawable[] mPlacePictures;
    public PhonefinderAdapter(Context context) {
        Resources resources = context.getResources();
        mPlaces = resources.getStringArray(R.array.phoneFinderArray);
        TypedArray a = resources.obtainTypedArray(R.array.phoneFinderImage);
        mPlacePictures = new Drawable[a.length()];
        for (int i = 0; i < mPlacePictures.length; i++) {
            mPlacePictures[i] = a.getDrawable(i);
        }
        a.recycle();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.picture.setImageDrawable(mPlacePictures[position % mPlacePictures.length]);
        holder.name.setText(mPlaces[position % mPlaces.length]);
    }
    @Override
    public int getItemCount() {
        return LENGTH;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView name ,txtcategorycount;
        private String[] brandname ,operatingsystem;

        private ArrayList<String[]> listDialogvalue = new ArrayList<String[]>();
        private String[] category;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.layout_phonefinder_item, parent, false));
            picture = (ImageView) itemView.findViewById(R.id.img_phonefinder);
            txtcategorycount = (TextView) itemView.findViewById(R.id.txt_categorycount);
            name = (TextView) itemView.findViewById(R.id.txt_phonefinder);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    operatingsystem = context.getResources().getStringArray(R.array.OperatingSyatem);
                    category        = context.getResources().getStringArray(R.array.phoneFinderArray);
                    brandname       = context.getResources().getStringArray(R.array.phoneBrandname);
                    listDialogvalue.add(0,brandname);
                    listDialogvalue.add(1,operatingsystem);
                    listDialogvalue.add(2,context.getResources().getStringArray(R.array.frontCamera));
                    listDialogvalue.add(3,context.getResources().getStringArray(R.array.rearCamera));
                    listDialogvalue.add(4,context.getResources().getStringArray(R.array.ram));
                    listDialogvalue.add(5,context.getResources().getStringArray(R.array.connector));
                    listDialogvalue.add(6,context.getResources().getStringArray(R.array.fingerprint));
                    listDialogvalue.add(7,context.getResources().getStringArray(R.array.cpu));
                    listDialogvalue.add(8,context.getResources().getStringArray(R.array.resolution));
                    listDialogvalue.add(9,context.getResources().getStringArray(R.array.no_of_slots));
                    listDialogvalue.add(10,context.getResources().getStringArray(R.array.chipset));
                    listDialogvalue.add(11,context.getResources().getStringArray(R.array.battery));
                    listDialogvalue.add(12,context.getResources().getStringArray(R.array.screensize));
                    listDialogvalue.add(13,context.getResources().getStringArray(R.array.phoneType));
                    DialogDemo dialog = new DialogDemo(context);
                    dialog.showDialogButtonClick(category[getAdapterPosition()],listDialogvalue.get(getAdapterPosition()),txtcategorycount);
                }
            });
        }

    }
}


