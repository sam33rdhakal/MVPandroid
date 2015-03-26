package com.enepalichords.nepalichords.Data;

import com.enepalichords.nepalichords.Data.Model.Artist;
import com.enepalichords.nepalichords.Data.Model.Menu;
import com.enepalichords.nepalichords.Data.Model.Song;

import java.util.List;


/**
 * Created by sameer on 3/3/15.
 */
public interface DataRepository {

    public List<Artist> getAllArtist();

    public List<Menu> getMenuList();

    public List<Song> getArtistSongs(int artistId);
}
