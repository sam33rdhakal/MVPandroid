package com.enepalichords.nepalichords.interactors.ArtistInformation;

import com.enepalichords.nepalichords.Data.DataModule;
import com.enepalichords.nepalichords.executor.ExecutorModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by sameer on 3/14/15.
 */

@Module(
        complete = false,
        library = true,
        includes = {DataModule.class, ExecutorModule.class}
)
public class ArtistInformationInteractorModule {

    @Provides
    @Singleton
    public GetSongsOfArtistInteractor provideArtistSongsInteractor(GetSongsOfArtistInteractorImpl getSongsOfArtistInteractorImpl){
        return getSongsOfArtistInteractorImpl;
    }

}
