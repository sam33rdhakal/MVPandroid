package com.enepalichords.nepalichords.interactors.Artist;

import com.enepalichords.nepalichords.Data.DataRepository;
import com.enepalichords.nepalichords.Data.Model.Artist;
import com.enepalichords.nepalichords.executor.Executor;
import com.enepalichords.nepalichords.executor.Interactor;
import com.enepalichords.nepalichords.executor.MainThread;

import java.util.List;

import javax.inject.Inject;


/**
 * Created by sameer on 3/4/15.
 */
public class GetArtistListInteractorImpl implements Interactor, GetArtistListInteractor {


    private final DataRepository dataRepository;
    private final Executor executor;
    private final MainThread mainThread;
    private Callback callback;

    @Inject
    public GetArtistListInteractorImpl(DataRepository dataRepository, Executor executor, MainThread mainThread) {
        this.dataRepository = dataRepository;
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
        List<Artist> artists = dataRepository.getAllArtist();
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
