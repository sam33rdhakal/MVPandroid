package com.enepalichords.nepalichords.interactors.ArtistInformation;

import com.enepalichords.nepalichords.Data.DataRepository;
import com.enepalichords.nepalichords.Data.Model.Song;
import com.enepalichords.nepalichords.executor.Executor;
import com.enepalichords.nepalichords.executor.Interactor;
import com.enepalichords.nepalichords.executor.MainThread;

import java.util.List;

import javax.inject.Inject;


/**
 * Created by sameer on 3/14/15.
 */
public class GetSongsOfArtistInteractorImpl implements GetSongsOfArtistInteractor, Interactor {

    private final DataRepository dataRepository;
    private final Executor executor;
    private final MainThread mainThread;
    private Callback callback;

    @Inject
    public GetSongsOfArtistInteractorImpl(DataRepository dataRepository, Executor executor, MainThread mainThread) {
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
        List<Song> songs = dataRepository.getArtistSongs(1);
        notifyArtistsSongLoaded(songs);
    }

    private void notifyArtistsSongLoaded(final List<Song> songs) {
        mainThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onSongListLoaded(songs);
            }
        });
    }
}
