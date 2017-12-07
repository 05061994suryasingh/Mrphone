package com.chromeinfotech.mrphone.view.ui.activity.country;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chromeinfotech.mrphone.R;

/**
 * Created by user on 31/8/17.
 */

public class ChooseCountryAdapter extends RecyclerView.Adapter<ChooseCountryAdapter.MyViewHolder> {

    private String countryList[];

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.txt_countryname);
        }
    }


    public ChooseCountryAdapter(String[] moviesList) {
        this.countryList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_recycleview, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(countryList[position]);

    }

    @Override
    public int getItemCount() {
        return countryList.length;
    }
}