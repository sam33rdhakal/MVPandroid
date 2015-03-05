package com.enepalichords.nepalichords.interactors;

import com.enepalichords.nepalichords.Data.DataModule;
import com.enepalichords.nepalichords.Data.SongRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by sameer on 3/4/15.
 */
@Module(
        injects = DBInteractorImpl.class,
        includes = DataModule.class,
        library = true
)
public class DBInteractorModule {

    @Provides
    @Singleton
    public DBInteractor provideDBInteractor(SongRepository songrepository) {
        return new DBInteractorImpl(songrepository);
    }
}
