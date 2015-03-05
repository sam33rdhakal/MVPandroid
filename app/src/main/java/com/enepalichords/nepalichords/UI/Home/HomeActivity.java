package com.enepalichords.nepalichords.UI.Home;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.enepalichords.nepalichords.Data.Model.Artist;
import com.enepalichords.nepalichords.R;
import com.enepalichords.nepalichords.UI.Common.BaseActivity;
import com.enepalichords.nepalichords.UI.Common.Utils;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class HomeActivity extends BaseActivity implements HomeView {

    @InjectView(R.id.app_bar) Toolbar toolbar;
    @Inject NavigationDrawerFragment navigationDrawerFragment;
    @Inject HomePresenter homePresenter;
    @InjectView(R.id.artistTxt) EditText artistEditText;
    @InjectView(R.id.descriptionTxt) EditText artistDescriptionEditText;

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
    public void loadArtistList(List<Artist> artists) {
        navigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        navigationDrawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar, artists);
    }

    @Override
    public void addArtistToList(Artist artist) {
        navigationDrawerFragment.updateMenuList(artist);
    }

    public void displayToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @OnClick(R.id.btnCreateArtist)
    public void submit(View view) {
        hideKeyboard();
        if (homePresenter.saveArtist(artistEditText.getText().toString(), artistDescriptionEditText.getText().toString()))
        {
            Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void clearInput() {
        artistEditText.setText("");
        artistDescriptionEditText.setText("");
    }

    @Override
    public void showArtistNameError(String errorMessage) {
        artistEditText.setError(errorMessage);

    }

    @Override
    public void showArtistDescriptionError() {
        artistDescriptionEditText.setError(getString(R.string.artistDescription_error));
    }

    public void hideKeyboard() {
        Utils.hide_keyboard(this);
    }
}

