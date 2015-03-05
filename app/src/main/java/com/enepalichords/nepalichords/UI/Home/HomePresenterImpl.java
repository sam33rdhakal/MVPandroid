package com.enepalichords.nepalichords.UI.Home;

import android.text.TextUtils;

import com.enepalichords.nepalichords.Data.Model.Artist;
import com.enepalichords.nepalichords.interactors.DBInteractor;

import java.util.List;


/**
 * Created by sameer on 3/3/15.
 */
public class HomePresenterImpl implements HomePresenter, HomeCallBack {

    private DBInteractor dbInteractor;
    private HomeView homeView;

    public HomePresenterImpl(DBInteractor dbInteractor, HomeView homeView) {
        this.dbInteractor = dbInteractor;
        this.homeView = homeView;
    }

    @Override
    public boolean saveArtist(String name, String description) {
        boolean flag = true;

        if (TextUtils.isEmpty(name))
        {
            flag = false;
            showArtistNameError("Artist name cant be null");
        }

        if (TextUtils.isEmpty(description))
        {
            flag = false;
            showArtistDescriptionError();
        }

        if (flag)
        {
            dbInteractor.saveArtist(name, description, this);
            homeView.clearInput();
        }

        return flag;
    }

    @Override
    public void getArtistList() {
        dbInteractor.getAllArtist(this);
    }

    @Override
    public void updateMenu(Artist artist) {
        homeView.addArtistToList(artist);
    }

    @Override
    public void loadMenu(List<Artist> artists) {
        homeView.loadArtistList(artists);
    }


    public void showArtistNameError(String message) {
        homeView.showArtistNameError(message);
    }

    public void showArtistDescriptionError() {
        homeView.showArtistDescriptionError();
    }
}
