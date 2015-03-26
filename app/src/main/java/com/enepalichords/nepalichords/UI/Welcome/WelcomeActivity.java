package com.enepalichords.nepalichords.UI.Welcome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.enepalichords.nepalichords.R;
import com.enepalichords.nepalichords.UI.Artist.ArtistActivity;
import com.enepalichords.nepalichords.UI.Common.View.BaseActivity;

import java.util.LinkedList;
import java.util.List;


public class WelcomeActivity extends BaseActivity implements WelcomeView {

    private final String SPLASH_FRAGMENT_TAG = "splash_screen_fragment";
    SplashFragment splashFragment;

    @Override
    public List<Object> getModules() {
//        return Arrays.<Object>asList(new WelcomeModule());
        LinkedList<Object> modules = new LinkedList<>();
        modules.add(new WelcomeModule());
        return modules;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showSplashScreen();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                jumpToHomeActivity();
            }
        }, 2000);
    }

    @Override
    public void showSplashScreen() {
        splashFragment = SplashFragment.getInstance();
        addFragment(android.R.id.content, splashFragment, SPLASH_FRAGMENT_TAG);
    }

    @Override
    public void hideSplashScreen() {
        removeFragment(SPLASH_FRAGMENT_TAG);
    }

    @Override
    public void jumpToHomeActivity() {
        startActivity(new Intent(this, ArtistActivity.class));
        finish();
    }
}
