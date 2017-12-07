package com.chromeinfotech.mrphone.view.ui.activity.splash;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.chromeinfotech.mrphone.R;
import com.chromeinfotech.mrphone.model.PrefManager;
import com.chromeinfotech.mrphone.controller.utils.Utils;
import com.chromeinfotech.mrphone.view.ui.activity.main.MainActivity;
import com.chromeinfotech.mrphone.view.ui.activity.welcome.WelcomeActivity;

public class SplashActivity extends  AppCompatActivity {

    private static int SPLASH_TIME_OUT=2000;
    private PrefManager prefManager;

    /**
     * On Create Override .
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.splashActivityShow();
    }

    private void launchWelcomeScreen() {
        startActivity(new Intent(SplashActivity.this, WelcomeActivity.class));
        finish();
    }
    /**
     *  Showing splash screen with a timer. This will be useful when you
     * want to show case your app logo Company.
     */
    private void splashActivityShow() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Checking for first time launch - before calling setContentView()
                prefManager = new PrefManager(SplashActivity.this);
                if (prefManager.isFirstTimeLaunch()) {
                    launchWelcomeScreen();
                    Utils.printLog("SplashActivity","prefManager ="+prefManager.isFirstTimeLaunch());
                    finish();
                }else {
                    Utils.printLog("SplashActivity","prefManager ="+prefManager.isFirstTimeLaunch());
                    showLoginActivity();
                }
                // Making notification bar transparent
                if (Build.VERSION.SDK_INT >= 21) {
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                }
               // showLoginActivity();
                finish();
            }
        }, SPLASH_TIME_OUT);

    }


    /**
     * Move To LoginActivity
     */
    private void showLoginActivity() {
        startActivity(  new Intent(SplashActivity.this,MainActivity.class )   );
    }

}