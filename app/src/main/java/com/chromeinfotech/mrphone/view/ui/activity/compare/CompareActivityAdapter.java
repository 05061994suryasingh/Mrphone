package com.chromeinfotech.mrphone.view.ui.activity.compare;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.chromeinfotech.mrphone.R;
import com.chromeinfotech.mrphone.view.adapter.ComparePhoneAdapter;
import com.chromeinfotech.mrphone.view.ui.activity.serachPhone.PhonesearchDetailsActivity;

/**
 * Created by user on 7/9/17.
 */

public class CompareActivityAdapter extends RecyclerView.Adapter<CompareActivityAdapter.ViewHolder> {
    private Context context ;
    private static final int LENGTH = 1;
    public CompareActivityAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_comare_phone, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ComparePhoneAdapter comparePhoneAdapter = new ComparePhoneAdapter(context);
        holder.listviewcard.setAdapter(comparePhoneAdapter);
    }

    @Override
    public int getItemCount() {
        return LENGTH;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private  ListView listviewcard ;
        public ViewHolder(View itemView) {
            super(itemView);
            listviewcard = (ListView) itemView.findViewById(R.id.listviewcard);
            listviewcard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    context.startActivity(new Intent(context,PhonesearchDetailsActivity.class));
                }
            });
        }
    }
}
