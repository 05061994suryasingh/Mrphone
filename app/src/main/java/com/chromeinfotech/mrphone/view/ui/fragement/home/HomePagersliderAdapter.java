package com.chromeinfotech.mrphone.view.ui.fragement.home;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chromeinfotech.mrphone.R;

/**
 * Created by user on 1/9/17.
 */

public class HomePagersliderAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater mLayoutInflater;
    private int[] myImages ;

    public HomePagersliderAdapter(Context context, int[] myImages) {
        this.context = context;
        this.myImages = myImages ;
    }
    @Override
    public int getCount() {
        return myImages.length;
    }
    @Override
    public boolean isViewFromObject(View view , Object object) {
        return view == ((CardView) object);
    }
    /**
     * distroy the view
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((CardView) object);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        mLayoutInflater = LayoutInflater.from(context);
        View view = mLayoutInflater.inflate(R.layout.layout_cardview_home_slider, container, false);
        ImageView imgSliderIcon = (ImageView) view.findViewById(R.id.img_slider_icon);
        imgSliderIcon.setImageResource(myImages[position]);
        container.addView(view);
        return view;
    }
}