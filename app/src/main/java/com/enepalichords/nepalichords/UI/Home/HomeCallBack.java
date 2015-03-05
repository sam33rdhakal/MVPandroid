package com.enepalichords.nepalichords.UI.Home;

import com.enepalichords.nepalichords.Data.Model.Artist;

import java.util.List;


/**
 * Created by sameer on 3/4/15.
 */
public interface HomeCallBack {

    public void updateMenu(List<Artist> artists);

    public void displayError();
}
