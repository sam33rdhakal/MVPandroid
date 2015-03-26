package com.enepalichords.nepalichords.UI.ArtistInformation;

import com.enepalichords.nepalichords.UI.ArtistInformation.fragments.SongDetailFragment;
import com.enepalichords.nepalichords.interactors.ArtistInformation.ArtistInformationInteractorModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by sameer on 3/14/15.
 */
@Module(
        injects = ArtistInformationActivity.class,
        includes = {ArtistInformationInteractorModule.class}
)
public class ArtistInformationModule {

    private ArtistInformationView artistInformationView;

    public ArtistInformationModule(ArtistInformationView artistInformationView) {
        this.artistInformationView = artistInformationView;
    }

    @Provides
    @Singleton
    public ArtistInformationPresenter provideArtistInformationPresenter(ArtistInformationPresenterImpl artistInformationPresenter) {
        return artistInformationPresenter;
    }

    @Provides
    @Singleton
    public ArtistInformationView provideArtistInformationView() {
        return this.artistInformationView;
    }

    @Provides
    @Singleton
    public SongDetailFragment provideSongDetailFragment(){
        return new SongDetailFragment();
    }


}
