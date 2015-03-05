package com.enepalichords.nepalichords.UI.Home;

import android.util.Log;

import com.enepalichords.nepalichords.interactors.DBInteractor;
import com.enepalichords.nepalichords.interactors.DBInteractorModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by sameer on 3/3/15.
 */

@Module(
        injects = HomeActivity.class,
        includes = DBInteractorModule.class
        //library = true
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
    public HomePresenter provideHomePresenter(DBInteractor dbInteractor, HomeView homeView) {
        Log.d("HOMEMODULE", "creating presenter");
        return new HomePresenterImpl(dbInteractor, homeView);
    }

    @Provides
    public NavigationDrawerFragment provideNavigationFragment() {
        return new NavigationDrawerFragment();
    }

}
