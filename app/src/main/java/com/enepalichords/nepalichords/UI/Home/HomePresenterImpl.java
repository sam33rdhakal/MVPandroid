package com.enepalichords.nepalichords.UI.Home;

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
        dbInteractor.saveArtist(name, description, this);
        return true;
    }

    @Override
    public void getArtistList() {
        dbInteractor.getAllArtist(this);
    }

    @Override
    public void updateMenu(List<Artist> artists) {
        homeView.updateArtistList(artists);
    }

    @Override
    public void displayError() {

    }
}
