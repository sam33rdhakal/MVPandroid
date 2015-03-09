package com.enepalichords.nepalichords.executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by sameer on 3/8/15.
 */
@Module(library = true)

public class ExecutorModule {

    @Provides @Singleton Executor provideExecutor(ThreadExecutor threadExecutor){
        return threadExecutor;
    }

    @Provides @Singleton MainThread provideMainThread(MainThreadImpl impl){
        return impl;
    }

}
