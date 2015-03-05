package com.enepalichords.nepalichords.interactors;

import com.enepalichords.nepalichords.Data.Model.Artist;
import com.enepalichords.nepalichords.UI.Home.HomeCallBack;

import java.util.List;


/**
 * Created by sameer on 2/28/15.
 */

public interface DBInteractor {

    public void saveArtist(String name, String description, HomeCallBack callBack);

    public void getAllArtist(HomeCallBack callBack);
}
