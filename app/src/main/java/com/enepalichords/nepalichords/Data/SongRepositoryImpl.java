package com.enepalichords.nepalichords.Data;

import android.os.Handler;

import com.enepalichords.nepalichords.Data.Model.Artist;
import com.enepalichords.nepalichords.Data.Model.ModelFactory;
import com.enepalichords.nepalichords.UI.Home.HomeCallBack;

import java.util.List;


/**
 * Created by sameer on 3/3/15.
 */
public class SongRepositoryImpl implements SongRepository {

    @Override
    public void createArtist(String artistName, String artistDescription) {
        Artist artist = ModelFactory.createArtistObject(artistName, artistDescription);
        artist.save();
    }

    @Override
    public Artist readArtist(int artistId) {
        return null;
    }

    @Override
    public void deleteArtist() {

    }

    @Override
    public List<Artist> getAllArtist() {
        return ModelFactory.getAll();
    }
}
