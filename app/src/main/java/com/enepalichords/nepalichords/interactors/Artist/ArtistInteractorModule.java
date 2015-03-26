package com.enepalichords.nepalichords.interactors.Artist;

import com.enepalichords.nepalichords.Data.DataModule;
import com.enepalichords.nepalichords.executor.ExecutorModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by sameer on 3/4/15.
 */
@Module(
        complete = false,
        library = true,
        includes = {DataModule.class, ExecutorModule.class}
)
public final class ArtistInteractorModule {

    @Provides
    @Singleton
    public GetArtistListInteractor provideDBInteractor(GetArtistListInteractorImpl getArtistListInteractor) {
        return getArtistListInteractor;
    }

    @Provides
    @Singleton
    public GetMenuListInteractor provideMenuInteractor(GetMenuListInteractorImpl getMenuListInteractor) {
        return getMenuListInteractor;

    }
}
