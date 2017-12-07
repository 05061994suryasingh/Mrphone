package com.chromeinfotech.mrphone.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.chromeinfotech.mrphone.R;
import com.chromeinfotech.mrphone.view.ui.activity.detail.DetailActivity;

/**
 * Created by user on 4/9/17.
 */

public class HomeRecyclerContentAdapter extends RecyclerView.Adapter<HomeRecyclerContentAdapter.ViewHolder> {
    // Set numbers of Card in RecyclerView.
    private static final int LENGTH = 10;

    private final String[] modelname;
    private final String[] modelDescription;
    private final Drawable[] mPlacePictures;

    public HomeRecyclerContentAdapter(Context context) {
        Resources resources = context.getResources();
        modelname = resources.getStringArray(R.array.mobile);
        modelDescription = resources.getStringArray(R.array.mobile_discription);
        TypedArray a = resources.obtainTypedArray(R.array.mobile_picture);
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
        holder.modelName.setText(modelname[position % modelname.length]);
        holder.description.setText(modelDescription[position % modelDescription.length]);
    }

    @Override
    public int getItemCount() {
        return LENGTH;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView picture;
        public TextView websitename,date,modelName,totalview,txt_Likecount ,txt_chatcount;
        public TextView description;
        private ImageButton imgbtnLike,imgbtn_chat ,imgbtnShare;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.layout_home_recler_item, parent, false));
            picture     = (ImageView) itemView.findViewById(R.id.card_image_home_recyclerview);
            websitename = (TextView)  itemView.findViewById(R.id.card_txt_sitename);
            date        = (TextView)  itemView.findViewById(R.id.card_txt_date);
            description = (TextView)  itemView.findViewById(R.id.card_text_home_recyclerview);
            modelName   = (TextView)  itemView.findViewById(R.id.card_txt_modelname);
            totalview   = (TextView)  itemView.findViewById(R.id.card_txt_user_view);

            imgbtnLike      = (ImageButton) itemView.findViewById(R.id.imgbtn_like);
            imgbtn_chat     = (ImageButton) itemView.findViewById(R.id.imgbtn_chat);
            imgbtnShare     = (ImageButton) itemView.findViewById(R.id.share_button_home_recyclerview);
            imgbtnLike.setOnClickListener(this);
            imgbtn_chat.setOnClickListener(this);
            imgbtnShare.setOnClickListener(this);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_POSITION, getAdapterPosition());
                    context.startActivity(intent);
                }
            });

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.imgbtn_like :
                    Snackbar.make(v, "Like is pressed",
                            Snackbar.LENGTH_LONG).show();
                    break ;
                case R.id.imgbtn_chat :
                    Snackbar.make(v, "Chat is pressed",
                            Snackbar.LENGTH_LONG).show();
                    break ;
                case R.id.share_button_home_recyclerview :
                    Snackbar.make(v, "Share is pressed",
                            Snackbar.LENGTH_LONG).show();
                    break ;
            }
        }
    }
}
