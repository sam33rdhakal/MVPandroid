package com.enepalichords.nepalichords;

import android.app.Application;
import android.os.Handler;

import java.util.LinkedList;
import java.util.List;

import dagger.ObjectGraph;


/**
 * Created by sameer on 3/1/15.
 */

public class App extends Application {

    //define the dependency graph
    private ObjectGraph objectGraph;
    private long mUiThreadId;
    private Handler mUiHandler;

    @Override
    public void onCreate() {
        super.onCreate();

        //initialize the dependency graph
        objectGraph = ObjectGraph.create(getModules().toArray());
        objectGraph.inject(this);

        //get UI thread ID
        mUiThreadId = Thread.currentThread().getId();
        mUiHandler = new Handler();

    }

    //custom function to runOnUiThread
    public void customRunOnUiThread(Runnable action) {
        if (Thread.currentThread().getId() != mUiThreadId)
        {
            mUiHandler.post(action);
        } else
        {
            action.run();
        }
    }

    //method to add the scoped dependency into the graph
    public ObjectGraph createScopedGraph(Object... modules) {
        return objectGraph.plus(modules);
    }

    //load the dependencies soon after application launches
    public List<Object> getModules() {
        LinkedList<Object> modules = new LinkedList<>();
        modules.add(new AppModule(this));
        return modules;
    }
}
