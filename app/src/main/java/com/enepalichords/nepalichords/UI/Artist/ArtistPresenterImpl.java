package com.enepalichords.nepalichords.UI.Artist;

import com.enepalichords.nepalichords.Data.Model.Artist;
import com.enepalichords.nepalichords.Data.Model.Menu;
import com.enepalichords.nepalichords.interactors.Artist.GetArtistListInteractor;
import com.enepalichords.nepalichords.interactors.Artist.GetMenuListInteractor;

import java.util.List;

import javax.inject.Inject;


/**
 * Created by sameer on 3/3/15.
 */
public class ArtistPresenterImpl implements ArtistPresenter {

    private GetArtistListInteractor getArtistListInteractor;
    private GetMenuListInteractor getMenuListInteractor;
    private ArtistView artistView;

    @Inject
    public ArtistPresenterImpl(GetArtistListInteractor getArtistListInteractor, GetMenuListInteractor getMenuListInteractor, ArtistView artistView) {
        this.getArtistListInteractor = getArtistListInteractor;
        this.getMenuListInteractor = getMenuListInteractor;
        this.artistView = artistView;
    }

    @Override
    public void getArtistList() {
        getArtistListInteractor.execute(new GetArtistListInteractor.Callback() {
            @Override
            public void onArtistLoaded(List<Artist> artists) {
                artistView.loadArtistList(artists);
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void getMenuList() {

        getMenuListInteractor.Execute(new GetMenuListInteractor.Callback() {
            @Override
            public void OnMenuListCreated(List<Menu> menus) {
                artistView.loadMenuList(menus);
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void getSongsByArtistId(int artistId) {

    }
}
