package com.enepalichords.nepalichords.UI.Home;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

import com.enepalichords.nepalichords.Data.Model.Artist;
import com.enepalichords.nepalichords.R;
import com.enepalichords.nepalichords.UI.Common.BaseActivity;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class HomeActivity extends BaseActivity implements HomeView {

    @InjectView(R.id.app_bar) Toolbar toolbar;
    @Inject NavigationDrawerFragment navigationDrawerFragment;
    @Inject HomePresenter homePresenter;


    @Override
    public List<Object> getModules() {
        return Arrays.<Object>asList(new HomeModule(this));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.inject(this);
        displayToolbar();
        homePresenter.getArtistList();
    }

    @Override
    public void updateArtistList(List<Artist> artists) {
        navigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        navigationDrawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar, artists);
    }

    public void displayToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
