package com.enepalichords.nepalichords.UI.Artist;

import android.content.Context;

import com.enepalichords.nepalichords.UI.Artist.fragments.NavigationDrawerFragment;
import com.enepalichords.nepalichords.interactors.Artist.ArtistInteractorModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by sameer on 3/3/15.
 */
@Module(
        injects = {ArtistActivity.class, NavigationDrawerFragment.class},
        includes = {ArtistInteractorModule.class},
        library = true
)

public class ArtistModule {

    private ArtistView artistView;

    public ArtistModule(ArtistView artistView) {
        this.artistView = artistView;

    }

    @Provides
    @Singleton
    public Context provideContext() {
        return (Context) artistView;
    }

    @Provides
    @Singleton
    public ArtistView provideHomeView() {
        return this.artistView;
    }

    @Provides
    @Singleton
    public ArtistPresenter provideHomePresenter(ArtistPresenterImpl homePresenter) {
        return homePresenter;
    }

    @Provides
    public NavigationDrawerFragment provideNavigationFragment() {
        return new NavigationDrawerFragment();
    }
}
