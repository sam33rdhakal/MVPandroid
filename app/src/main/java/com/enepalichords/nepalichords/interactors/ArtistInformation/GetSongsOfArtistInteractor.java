package com.enepalichords.nepalichords.interactors.ArtistInformation;

import com.enepalichords.nepalichords.Data.Model.Song;

import java.util.List;


/**
 * Created by sameer on 3/14/15.
 */
public interface GetSongsOfArtistInteractor {

    interface Callback {

        void onSongListLoaded(final List<Song> songs);

        void onError();
    }

    public void execute(Callback callBack);

}
