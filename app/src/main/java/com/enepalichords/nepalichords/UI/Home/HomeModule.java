package com.enepalichords.nepalichords.UI.Home;

import android.support.v7.widget.RecyclerView;

import com.enepalichords.nepalichords.interactors.GetArtistModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by sameer on 3/3/15.
 */

@Module(
        injects = {HomeActivity.class, NavigationDrawerFragment.class},
        includes = {GetArtistModule.class}

)
public class HomeModule {

    private HomeView homeView;

    public HomeModule(HomeView homeView) {
        this.homeView = homeView;
    }

    @Provides
    @Singleton
    public HomeView provideHomeView() {
        return this.homeView;
    }

    @Provides
    @Singleton
    public HomePresenter provideHomePresenter(HomePresenterImpl homePresenter) {
        return homePresenter;
    }

    @Provides
    public NavigationDrawerFragment provideNavigationFragment() {
        return new NavigationDrawerFragment();
    }
}
