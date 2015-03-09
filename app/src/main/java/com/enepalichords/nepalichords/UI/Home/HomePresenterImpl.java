package com.enepalichords.nepalichords.UI.Home;

import com.enepalichords.nepalichords.Data.Model.Artist;
import com.enepalichords.nepalichords.interactors.GetArtistListInteractor;

import java.util.List;

import javax.inject.Inject;


/**
 * Created by sameer on 3/3/15.
 */
public class HomePresenterImpl implements HomePresenter {

    private GetArtistListInteractor getArtistListInteractor;
    private HomeView homeView;

    @Inject
    public HomePresenterImpl(GetArtistListInteractor getArtistListInteractor, HomeView homeView) {
        this.getArtistListInteractor = getArtistListInteractor;
        this.homeView = homeView;
    }

    @Override
    public void getArtistList() {
        getArtistListInteractor.execute(new GetArtistListInteractor.Callback() {
            @Override
            public void onArtistLoaded(List<Artist> artists) {
                homeView.loadArtistList(artists);
            }

            @Override
            public void onError() {

            }
        });
    }
}
