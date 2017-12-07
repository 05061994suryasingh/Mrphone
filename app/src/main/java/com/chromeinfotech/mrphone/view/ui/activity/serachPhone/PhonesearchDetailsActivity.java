package com.chromeinfotech.mrphone.view.ui.activity.serachPhone;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

import com.chromeinfotech.mrphone.R;
import com.chromeinfotech.mrphone.controller.utils.Utils;
import com.chromeinfotech.mrphone.view.ui.activity.BaseActivity.BaseActivity;

public class PhonesearchDetailsActivity extends BaseActivity implements TabLayout.OnTabSelectedListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_comparision);
        this.reference();
        this.setListenrs();
        this.setTab();
        this.setAdapter();
    }

    private void setTab() {
        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("SUMMARY"));
        tabLayout.addTab(tabLayout.newTab().setText("SPACES"));
        tabLayout.addTab(tabLayout.newTab().setText("STORIES"));
        tabLayout.addTab(tabLayout.newTab().setText("REVIEW"));
        tabLayout.addTab(tabLayout.newTab().setText("BUY"));
    }

    private void setAdapter() {
        //Creating our pager adapter
        phoneSearchviewPagerAdapter adapter = new phoneSearchviewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        //Adding adapter to pager
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
        tabLayout.setSelected(true);
        Utils.printLog("PhonesearchDetailsActivity","PhonesearchDetailsActivity="+tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void reference() {
        //Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.pager);
        scrollView = (ScrollView) findViewById(R.id.scrollView

        );
    }

    @Override
    public void setListenrs() {
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(this);
        final GestureDetector mGestureDetector= new GestureDetector(this,new XScrollDetector());
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                viewPager.getParent().requestDisallowInterceptTouchEvent(true);
            }
        });
    }
    public  static class XScrollDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return Math.abs(distanceY) < Math.abs(distanceX);
        }
    }
}
