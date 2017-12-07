package com.chromeinfotech.mrphone.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chromeinfotech.mrphone.R;
import com.chromeinfotech.mrphone.controller.utils.Utils;
import com.chromeinfotech.mrphone.model.ComparePhoneModel;

import java.util.ArrayList;

/**
 * Created by user on 7/9/17.
 */

public class ComparePhoneAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater mLayoutInflater;
    private ArrayList<ComparePhoneModel> phoneListModel = new ArrayList<>();
    private final String[] modelname;
    private final Drawable[] mPlacePictures ;
    private      ComparePhoneModel comparePhoneModel ;

    public ComparePhoneAdapter(Context context) {
        this.context = context;
        Resources resources = context.getResources();
        modelname = resources.getStringArray(R.array.mobile_name);
        TypedArray a = resources.obtainTypedArray(R.array.mobile_namewith_picture);
        mPlacePictures = new Drawable[a.length()];
        for (int i = 0; i < mPlacePictures.length; i++) {
            // mPlacePictures[i] = a.getDrawable(i);
            Utils.printLog("ComparePhoneAdapter","="+mPlacePictures[i]);

            comparePhoneModel = new ComparePhoneModel();
            comparePhoneModel.setPhonename(modelname[i]);
            comparePhoneModel.setPhoneimage(a.getDrawable(i));
            phoneListModel.add(i,comparePhoneModel) ;
        }
        a.recycle();
        this.mLayoutInflater = LayoutInflater.from(context);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.layout_comare_phone_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.phoneName.setText(phoneListModel.get(position).getPhonename());
        Utils.printLog("ComparePhoneAdapter","="+phoneListModel.get(position).getPhonename());
        Utils.printLog("ComparePhoneAdapter","="+phoneListModel.get(position).getPhoneimage());
        viewHolder.imgPhoneicon.setImageDrawable(phoneListModel.get(position).getPhoneimage());
        return convertView;
    }


    @Override
    public int getCount() {
        return phoneListModel.size();
    }

    @Override
    public ComparePhoneModel getItem(int position) {
        return phoneListModel.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        private ImageView imgPhoneicon;
        private TextView phoneName;

        public ViewHolder(View view) {
            imgPhoneicon = (ImageView) view.findViewById(R.id.img_phonecompareicon);
            phoneName    = (TextView)  view.findViewById(R.id.txt_phoneName);
        }
    }
}
