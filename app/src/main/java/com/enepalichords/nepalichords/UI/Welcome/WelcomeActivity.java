package com.enepalichords.nepalichords.UI.Welcome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.enepalichords.nepalichords.UI.Common.BaseActivity;
import com.enepalichords.nepalichords.UI.Home.HomeActivity;
import com.enepalichords.nepalichords.R;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;


public class WelcomeActivity extends BaseActivity implements WelcomeView {

    private final String SPLASH_FRAGMENT_TAG = "splash_screen_fragment";
    SplashFragment splashFragment;

    @Override
    public List<Object> getModules() {
        return Arrays.<Object>asList(new WelcomeModule());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showSplashScreen();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                hideSplashScreen();
            }
        }, 3000);
    }

    @Override
    public void showSplashScreen() {
        splashFragment = SplashFragment.getInstance();
        addFragment(android.R.id.content, splashFragment, SPLASH_FRAGMENT_TAG);
    }

    @Override
    public void hideSplashScreen() {
        removeFragment(SPLASH_FRAGMENT_TAG);
        jumpToHomeActivity();
    }

    @Override
    public void jumpToHomeActivity() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }
}
