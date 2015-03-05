package com.enepalichords.nepalichords;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;


/**
 * Created by sameer on 3/1/15.
 */

public class App extends Application {

    //define the dependency graph
    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        //initialize the dependency graph
        objectGraph = ObjectGraph.create(getModules().toArray());
        objectGraph.inject(this);

        //initialize active android
        ActiveAndroid.initialize(this);
    }

    //method to add the scoped dependency into the graph
    public ObjectGraph createScopedGraph(Object... modules) {
        return objectGraph.plus(modules);
    }

    //load the dependencies soon after application launches
    public List<Object> getModules() {
        return Arrays.<Object>asList(new AppModule());
    }

}
