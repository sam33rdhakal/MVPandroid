package com.enepalichords.nepalichords.UI.ArtistInformation;

import com.enepalichords.nepalichords.Data.Model.Song;

import java.util.List;


/**
 * Created by sameer on 3/14/15.
 */
public interface ArtistInformationView {
    public void LoadArtistDetails(List<Song> songs);
    public void displayMessage();
}
