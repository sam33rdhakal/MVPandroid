package com.enepalichords.nepalichords;

import android.content.Context;

import dagger.Module;


/**
 * Created by sameer on 3/2/15.
 */

@Module(
        injects = App.class,
        complete = true,//includes = DataModule.class
        library = true
)
public class AppModule {

    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

//    @Provides
//    LayoutInflater provideLayoutInflater() {
//        return LayoutInflater.from(context);
//    }
}