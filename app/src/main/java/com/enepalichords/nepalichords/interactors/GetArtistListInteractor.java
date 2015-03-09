package com.enepalichords.nepalichords.interactors;

import com.enepalichords.nepalichords.Data.Model.Artist;

import java.util.List;


/**
 * Created by sameer on 2/28/15.
 */

public interface GetArtistListInteractor {

//    public void saveArtist(String name, String description, HomeCallBack callBack);

    interface Callback {

        void onArtistLoaded(final List<Artist> artists);

        void onError();
    }

    public void execute(Callback callBack);
}
