package com.enepalichords.nepalichords.interactors;

import android.os.Handler;

import com.enepalichords.nepalichords.Data.Model.Artist;
import com.enepalichords.nepalichords.Data.SongRepository;
import com.enepalichords.nepalichords.UI.Home.HomeCallBack;


/**
 * Created by sameer on 3/4/15.
 */
public class DBInteractorImpl implements DBInteractor {

    private SongRepository songRepository;

    public DBInteractorImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public void saveArtist(final String name, final String description, final HomeCallBack callBack) {
        final Artist artist = songRepository.createArtist(name, description);
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                callBack.updateMenu(artist);
            }
        });
    }

    @Override
    public void getAllArtist(final HomeCallBack callBack) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                callBack.loadMenu(songRepository.getAllArtist());
            }
        });
    }
}
