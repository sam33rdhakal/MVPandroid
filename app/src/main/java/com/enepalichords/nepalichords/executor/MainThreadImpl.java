package com.enepalichords.nepalichords.executor;

import android.os.Handler;
import android.os.Looper;

import javax.inject.Inject;


/**
 * Created by sameer on 3/8/15.
 */
public class MainThreadImpl implements MainThread {

    private Handler handler;

    @Inject
    public MainThreadImpl() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void post(Runnable task) {
        handler.post(task);
    }
}
