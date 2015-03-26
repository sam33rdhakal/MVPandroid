package com.enepalichords.nepalichords.UI.Artist;

import com.enepalichords.nepalichords.Data.Model.Artist;
import com.enepalichords.nepalichords.Data.Model.Menu;

import java.util.List;


/**
 * Created by sameer on 3/8/15.
 */
public interface ArtistView {

    public void loadArtistList(List<Artist> artists);

    public void loadMenuList(List<Menu> menus);

    public void loadArtistDetails(Artist artist);

}
