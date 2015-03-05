package com.enepalichords.nepalichords.UI.Home;

import com.enepalichords.nepalichords.Data.Model.Artist;

import java.util.List;


/**
 * Created by sameer on 3/1/15.
 */
public interface HomeView {

    public void loadArtistList(List<Artist> artists);

    public void addArtistToList(Artist artist);

    public void showArtistNameError(String errorMessage);

    public void showArtistDescriptionError();

    public void clearInput();
}
