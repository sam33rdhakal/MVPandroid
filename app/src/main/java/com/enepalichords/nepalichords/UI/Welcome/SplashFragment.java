package com.enepalichords.nepalichords.UI.Welcome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enepalichords.nepalichords.R;

import javax.inject.Inject;


/**
 * Created by sameer on 2/28/15.
 */
public class SplashFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.welcome_splash,container,false);
        return fragmentView;
    }

    public static SplashFragment getInstance(){
        return new SplashFragment();
    }

}
