package com.enepalichords.nepalichords.UI.Common;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.enepalichords.nepalichords.App;

import java.util.List;

import dagger.ObjectGraph;


/**
 * Created by sameer on 2/28/15.
 */
public abstract class BaseActivity extends ActionBarActivity {

    private ObjectGraph activityGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityGraph = ((App) getApplication()).createScopedGraph(getModules().toArray());
        activityGraph.inject(this);
    }

    //generic module to add the scoped activity
    public abstract List<Object> getModules();


    //remove module from the object graph
    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityGraph = null;
    }

    //add the fragment
    protected void addFragment(int containerViewId, Fragment fragment, String TAG) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment, TAG);
        fragmentTransaction.commit();
    }

    //remove the fragment
    protected void removeFragment(String TAG) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(TAG);
        if (fragment != null)
        {
            fragmentTransaction.remove(fragment);
            fragmentTransaction.commit();
        }
    }
}
