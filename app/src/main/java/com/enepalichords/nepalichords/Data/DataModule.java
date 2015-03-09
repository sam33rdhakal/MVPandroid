package com.enepalichords.nepalichords.Data;

import dagger.Module;
import dagger.Provides;


/**
 * Created by sameer on 3/3/15.
 */

@Module(
        library = true,
        complete = false
)

public class DataModule {

    @Provides
    public SongRepository provideSongRepository(FakeSongRepositoryImpl songRepository) {
        return songRepository;
    }
}
