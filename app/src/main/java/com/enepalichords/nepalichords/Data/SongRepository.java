package com.enepalichords.nepalichords.Data;

import com.enepalichords.nepalichords.Data.Model.Artist;
import com.enepalichords.nepalichords.UI.Home.HomeCallBack;

import java.util.List;


/**
 * Created by sameer on 3/3/15.
 */
public interface SongRepository {

    public Artist createArtist(String artistName, String artistDescription);

    public Artist readArtist(int artistId);

    public List<Artist> getAllArtist();

    public void deleteArtist();
}
