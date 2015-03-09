package com.enepalichords.nepalichords.interactors;

import com.enepalichords.nepalichords.Data.Model.Artist;
import com.enepalichords.nepalichords.Data.SongRepository;
import com.enepalichords.nepalichords.executor.Executor;
import com.enepalichords.nepalichords.executor.Interactor;
import com.enepalichords.nepalichords.executor.MainThread;

import java.util.List;

import javax.inject.Inject;


/**
 * Created by sameer on 3/4/15.
 */
public class GetArtistListInteractorImpl implements Interactor, GetArtistListInteractor {


    private final SongRepository songRepository;
    private final Executor executor;
    private final MainThread mainThread;
    private Callback callback;

    @Inject
    public GetArtistListInteractorImpl(SongRepository songRepository, Executor executor, MainThread mainThread) {
        this.songRepository = songRepository;
        this.executor = executor;
        this.mainThread = mainThread;
    }

    @Override
    public void execute(Callback callBack) {
        if (callBack != null)
        {
            this.callback = callBack;
            this.executor.run(this);
        }
    }

    @Override
    public void run() {
        List<Artist> artists = songRepository.getAllArtist();
        notifyArtistListFound(artists);
    }


    private void notifyArtistListFound(final List<Artist> artists) {
        mainThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onArtistLoaded(artists);
            }
        });
    }
}
