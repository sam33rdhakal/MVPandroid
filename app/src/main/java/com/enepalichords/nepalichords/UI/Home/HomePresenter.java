package com.enepalichords.nepalichords.UI.Home;

import com.enepalichords.nepalichords.Data.Model.Artist;

import java.util.List;


/**
 * Created by sameer on 3/1/15.
 */
public interface HomePresenter {

    public boolean saveArtist(String name, String description);

    public void getArtistList();
}
