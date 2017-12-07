package com.chromeinfotech.mrphone.view.ui.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.chromeinfotech.mrphone.R;
import com.chromeinfotech.mrphone.controller.dialog.CustomDialog;
import com.chromeinfotech.mrphone.controller.helper.BottomNavigationViewHelper;
import com.chromeinfotech.mrphone.controller.utils.Utils;
import com.chromeinfotech.mrphone.model.NotificationListModel;
import com.chromeinfotech.mrphone.model.PrefManager;
import com.chromeinfotech.mrphone.view.adapter.NotificationListAdapter;
import com.chromeinfotech.mrphone.view.adapter.ViewPagerAdapter;
import com.chromeinfotech.mrphone.view.ui.activity.BaseActivity.BaseActivity;
import com.chromeinfotech.mrphone.view.ui.activity.country.ChooseCountryActivity;
import com.chromeinfotech.mrphone.view.ui.fragement.event.EventFragements;
import com.chromeinfotech.mrphone.view.ui.fragement.feed.FeedsFragement;
import com.chromeinfotech.mrphone.view.ui.fragement.home.HomeFragement;
import com.chromeinfotech.mrphone.view.ui.fragement.latest.LatestMobileFragement;
import com.chromeinfotech.mrphone.view.ui.fragement.topChart.TopchartFragement;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener ,BottomNavigationView.OnNavigationItemSelectedListener ,ViewPager.OnPageChangeListener {

    private  LinearLayout llDrawerLeft ,llDrawerRight;
    private  Button btnLogin;
    private  ListView listNotification;
    private  ArrayList<NotificationListModel> notificationListModelList = new ArrayList<NotificationListModel>() ;
    private  NotificationListModel notificationListModel ;
    private  NotificationListAdapter notificationListAdapter ;
    private  ViewPager viewPager ;
    private  TextView txtTopBar ;
    private  DrawerLayout drawerLayout;
    private  ViewPagerAdapter viewPagerAdapter ;
    private  NavigationView navigationView;
    private  String TAG = this.getClass().getSimpleName();
    private  ImageView imgMenu, imgNotification;
    private  MenuItem prevMenuItem;
    private  PrefManager prefManager;
    private  String navItem [] ;
    private  final  int REQUESTCODE = 100 ;
    private  CustomDialog customDialog ;
    public   ArrayList<Fragment> fragments = new ArrayList<Fragment>();
    private  BottomNavigationView bottomNavigationView ;
    private  ImageView imgUserIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.reference();
        this.init();
        showSelectcountryDialog();
        this.intentvalue();
        this.setListenrs();
        this.setAdapter();
        this.setNotificationListAdapter();
    }

    private void showSelectcountryDialog() {
        Utils.printLog("MainActivity",""+prefManager.isFirstTimeHomeScreen());
        if(prefManager.isFirstTimeHomeScreen()){
            customDialog.showCustomAlertDialog();
            customDialog.btnChoose.setOnClickListener(this);
            customDialog.btnLater.setOnClickListener(this);
        }
    }

    private void setNotificationListAdapter() {
        notificationListAdapter = new NotificationListAdapter(this,notificationListModelList);
        listNotification.setAdapter(notificationListAdapter);
    }

    @Override
    public void init() {
        customDialog     = new CustomDialog(this) ;
        prefManager = new PrefManager(MainActivity.this);
        for (int i = 0; i < 10; i++) {
            notificationListModel = new NotificationListModel();
            notificationListModel.setNotification("Keep your cash! The Samsung Galaxy S8 Plus is a better value than the Note 8");
            notificationListModelList.add(notificationListModel) ;
        }
        navItem        =  this.getResources().getStringArray(R.array.NavItem);

    }

    /**
     * set the adapter to viewpager
     */
    private void setAdapter() {

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        HomeFragement homeFragement                 = new HomeFragement(this);
        LatestMobileFragement latestMobileFragement = new LatestMobileFragement();
        TopchartFragement topchartFragement         = new TopchartFragement();
        FeedsFragement feedsFragement               = new FeedsFragement();
        EventFragements eventFragements             = new EventFragements();
        viewPagerAdapter.addFragment(homeFragement);
        viewPagerAdapter.addFragment(latestMobileFragement);
        viewPagerAdapter.addFragment(feedsFragement);
        viewPagerAdapter.addFragment(topchartFragement);
        viewPagerAdapter.addFragment(eventFragements);
        viewPager.setAdapter(viewPagerAdapter);
        Utils.printLog(TAG,"outside setAdapter");
    }
    /**
     * add the fragment object to arraylist
     */
    private void setFragment() {
        Utils.printLog(TAG,"inside setFragment");
        HomeFragement homeFragement = new HomeFragement(this);
        LatestMobileFragement latestMobileFragement = new LatestMobileFragement();
        FeedsFragement feedsFragement = new FeedsFragement();
        TopchartFragement topchartFragement = new TopchartFragement();
        EventFragements eventFragements = new EventFragements();
        fragments.add(homeFragement);
        fragments.add(latestMobileFragement);
        fragments.add(topchartFragement);
        fragments.add(feedsFragement);
        fragments.add(eventFragements);
        Utils.printLog(TAG,"outside setFragment");
    }
    @Override
    public void reference() {
        navigationView         =   (NavigationView)        findViewById(R.id.navigation_drawer);
        llDrawerLeft           =   (LinearLayout)          findViewById(R.id.llDrawerLeft);
        llDrawerRight          =   (LinearLayout)          findViewById(R.id.llDrawerRight);
        drawerLayout           =   (DrawerLayout)          findViewById(R.id.drawer_layout);
        imgMenu                =   (ImageView)             findViewById(R.id.imgMenu);
        imgUserIcon            =   (ImageView)             findViewById(R.id.img_UserIcon);
        btnLogin               =   (Button)                findViewById(R.id.btnLogin);
        bottomNavigationView   =   (BottomNavigationView)  findViewById(R.id.bottom_navigation);
        viewPager              =   (ViewPager)             findViewById(R.id.content_viewPager);
        txtTopBar              =   (TextView)              findViewById(R.id.txtTopBar);
        imgNotification        =   (ImageView)             findViewById(R.id.imgNotification);
        listNotification       =   (ListView) findViewById(R.id.list_notification) ;
    }

    @Override
    public void setListenrs() {
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
            navigationView.bringToFront();
        }
        viewPager.addOnPageChangeListener(this);
        imgMenu.setOnClickListener(this);
        imgUserIcon.setOnClickListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);
        imgNotification.setOnClickListener(this);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, GravityCompat.END);
           }

    @Override
    public void intentvalue()   {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed
        Utils.printLog(TAG  , "inside onActivityResult()");
        if (requestCode == REQUESTCODE) {
            switch (resultCode) {
                case REQUESTCODE:
                    String message = data.getStringExtra("MESSAGE");
                    Utils.printLog(TAG  , "country=="+message);
                    break;
                case RESULT_CANCELED:
                    break;
                default:
                    break;
            }
        }
        Utils.printLog(TAG  , "outside onActivityResult()");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.imgMenu :
                Utils.printLog("surya","hello");
                drawerLayout.openDrawer(llDrawerLeft);
                break ;
            case  R.id.img_UserIcon :
                break ;
            case  R.id.imgNotification :
                drawerLayout.openDrawer(llDrawerRight);
                break ;
            case  R.id.btn_choose :
                prefManager.setFirstTimeHomeScreen(false);
                customDialog.dismiss();
                startActivityForResult(new Intent(MainActivity.this , ChooseCountryActivity.class),REQUESTCODE);
                break ;
            case  R.id.btn_Later :
                prefManager.setFirstTimeHomeScreen(false);
                customDialog.dismiss();
                break ;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_home:
                navigationView.setCheckedItem(R.id.nav_home);
                Utils.printLog(TAG,"0");
                break;
            case R.id.nav_brands:
                navigationView.setCheckedItem(R.id.nav_brands);
                Utils.printLog(TAG,"1");
                break;
            case R.id.nav_phone:
                navigationView.setCheckedItem(R.id.nav_phone);
                Utils.printLog(TAG,"2");
                break;
            case R.id.nav_video:
                navigationView.setCheckedItem(R.id.nav_video);
                Utils.printLog(TAG,"3");
                break;
            case R.id.nav_rate_us:
                navigationView.setCheckedItem(R.id.nav_rate_us);
                Utils.printLog(TAG,"4");
                break;
            case R.id.nav_share:
                navigationView.setCheckedItem(R.id.nav_share);
                Utils.printLog(TAG,"5");
                break;
            case R.id.nav_contact:
                navigationView.setCheckedItem(R.id.nav_contact);
                Utils.printLog(TAG,"6");
                break;
            case R.id.nav_settings:
                navigationView.setCheckedItem(R.id.nav_settings);
                Utils.printLog(TAG,"7");
                break;
            case R.id.menu_home:
                bottomNavigationView.bringToFront();
                viewPager.setCurrentItem(0);
                navigationView.setCheckedItem(R.id.menu_home);
                Utils.printLog(TAG,"menu_home");
                break;
            case R.id.menu_latest:
                viewPager.setCurrentItem(1);
                Utils.printLog(TAG,"menu_latest");
                break;
            case R.id.menu_TopCharts:
                viewPager.setCurrentItem(2);
                Utils.printLog(TAG,"menu_TopCharts");
                break;
            case R.id.menu_feeds:
                viewPager.setCurrentItem(3);
                Utils.printLog(TAG,"menu_feeds");
                break;
            case R.id.menu_events:
                viewPager.setCurrentItem(4);
                Utils.printLog(TAG,"menu_events");
                break;
            default:
        }

        return true;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }


    @Override
    public void onPageSelected(int position) {
        txtTopBar.setText(navItem[position]);
        if (prevMenuItem != null) {
            prevMenuItem.setChecked(false);
        }
        else
        {
            bottomNavigationView.getMenu().getItem(0).setChecked(false);
        }

        bottomNavigationView.getMenu().getItem(position).setChecked(true);
        prevMenuItem = bottomNavigationView.getMenu().getItem(position);
    }
    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
