package com.enepalichords.nepalichords.UI.ArtistInformation;

import com.enepalichords.nepalichords.Data.Model.Song;
import com.enepalichords.nepalichords.UI.Common.Utils.Utils;
import com.enepalichords.nepalichords.interactors.ArtistInformation.GetSongsOfArtistInteractor;

import java.util.List;

import javax.inject.Inject;


/**
 * Created by sameer on 3/14/15.
 */
public class ArtistInformationPresenterImpl implements ArtistInformationPresenter {

    private GetSongsOfArtistInteractor getSongsOfArtistInteractor;
    private ArtistInformationView artistInformationView;

    @Inject
    public ArtistInformationPresenterImpl(GetSongsOfArtistInteractor getSongsOfArtistInteractor, ArtistInformationView artistInformationView) {
        this.getSongsOfArtistInteractor = getSongsOfArtistInteractor;
        this.artistInformationView = artistInformationView;
    }

    @Override
    public void getArtistSongs(int artistId) {
        artistInformationView.displayMessage();
        getSongsOfArtistInteractor.execute(new GetSongsOfArtistInteractor.Callback() {
            @Override
            public void onSongListLoaded(List<Song> songs) {
                Utils.LogMessage("Inside the implementation");
                artistInformationView.LoadArtistDetails(songs);
            }

            @Override
            public void onError() {

            }
        });
    }
}
