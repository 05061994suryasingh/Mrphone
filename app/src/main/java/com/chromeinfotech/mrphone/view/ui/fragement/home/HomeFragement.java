package com.chromeinfotech.mrphone.view.ui.fragement.home;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chromeinfotech.mrphone.R;
import com.chromeinfotech.mrphone.view.adapter.HomeRecyclerContentAdapter;
import com.chromeinfotech.mrphone.view.ui.activity.compare.CompareActivty;
import com.chromeinfotech.mrphone.view.ui.activity.phonefinder.PhoneFinderActivity;
import com.chromeinfotech.mrphone.view.ui.activity.serachPhone.SearchPhoneActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by user on 13/4/17.
 */
public class HomeFragement extends Fragment implements View.OnClickListener {
    private ViewPager viewPager ;
    private Context context ;
    private LinearLayout dotsLayout;
    private View view ;
    private Timer viewPagerTimer ;
    private Handler handler ;
    private Button btnSearch;
    private TextView[] dots;
    private TextView txtPhoneFinder ,txtPhonecompare ;
    private Runnable update ;
    private int currentPage = 0 ;
    private RecyclerView homeRecycleview;
    private int[] myImages = new int[]{ R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f};

    public HomeFragement(Context context) {
        this.context =context ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(view == null) {
            view = inflater.inflate(R.layout.home_search_bar, null);
            dotsLayout = (LinearLayout) view.findViewById(R.id.circles);
            viewPager = (ViewPager) view.findViewById(R.id.home_viewpager);
            btnSearch = (Button)   view.findViewById(R.id.btn_search) ;
            txtPhoneFinder = (TextView) view.findViewById(R.id.txt_PhoneFinder);
            txtPhonecompare = (TextView) view.findViewById(R.id.txt_phonecompare);
            HomePagersliderAdapter adapter = new HomePagersliderAdapter(context, myImages);
            viewPager.setAdapter(adapter);
            viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
            txtPhoneFinder.setOnClickListener(this);
            txtPhonecompare.setOnClickListener(this);
            btnSearch.setOnClickListener(this);
            // adding bottom dots
            addBottomDots(0);
            startSlideShow();
            homeRecycleview = (RecyclerView) view.findViewById(R.id.home_recycleview) ;
            HomeRecyclerContentAdapter adapter1 = new HomeRecyclerContentAdapter(homeRecycleview.getContext());
            homeRecycleview.setAdapter(adapter1);
            homeRecycleview.setHasFixedSize(true);
            homeRecycleview.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        return view ;
    }
    //	viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
            currentPage=position ;
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    private void addBottomDots(int currentPage) {
        dots = new TextView[myImages.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(context);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }
        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }


    /**
     * Starts the slide show of slider of landing screen
     */
    private void startSlideShow() {

        if (viewPagerTimer == null) {
            viewPagerTimer = new Timer();
        }
        if (handler == null) {
            handler = new Handler();
        }
        try {
            update = new Runnable() {
                public void run() {
                    if (currentPage == myImages.length) {
                        currentPage = 0;
                    }
                    viewPager.setCurrentItem(currentPage++, true);
                }
            };
            if (viewPagerTimer != null)
                viewPagerTimer.schedule(new TimerTask() {

                    @Override
                    public void run() {
                        if (handler != null && update != null)
                            handler.post(update);
                    }
                }, 3000, 3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        startSlideShow();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (viewPagerTimer != null) {
            viewPagerTimer.cancel();
            viewPagerTimer = null;
        }
        handler = null;

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.txt_PhoneFinder:
                startActivity(new Intent(getActivity() , PhoneFinderActivity.class));
                break;
            case R.id.btn_search:
                startActivity(new Intent(getActivity() , SearchPhoneActivity.class));
                break;
            case R.id.txt_phonecompare:
                startActivity(new Intent(getActivity() , CompareActivty.class));
                break;
        }
    }
}
