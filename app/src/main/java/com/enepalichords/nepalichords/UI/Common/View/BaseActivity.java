package com.enepalichords.nepalichords.UI.Common.View;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.util.TypedValue;

import com.enepalichords.nepalichords.App;
import com.enepalichords.nepalichords.R;
import com.enepalichords.nepalichords.UI.Common.Utils.Utils;

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
        getWindow().getAttributes().windowAnimations = R.style.Fade;
    }

    //generic module to add the scoped activity
    public abstract List<Object> getModules();

    //remove module from the object graph
    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityGraph = null;
        Utils.LogMessage("Activity Graph Destroyed");
    }

    public void inject(Object object) {
        activityGraph.inject(object);
    }

    //add the fragment
    protected void addFragment(int containerViewId, Fragment fragment, String TAG) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
        fragmentTransaction.add(containerViewId, fragment, TAG);
        fragmentTransaction.addToBackStack(TAG);
        fragmentTransaction.commit();
    }

    //remove the fragment
    protected void removeFragment(String TAG) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(TAG);
        if (fragment != null)
        {
            fragmentTransaction.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
            fragmentTransaction.remove(fragment);
            fragmentTransaction.commit();
        }
    }


    protected int getActionBarSize() {
        TypedValue typedValue = new TypedValue();
        int[] textSizeAttr = new int[]{R.attr.actionBarSize};
        int indexOfAttrTextSize = 0;
        TypedArray a = obtainStyledAttributes(typedValue.data, textSizeAttr);
        int actionBarSize = a.getDimensionPixelSize(indexOfAttrTextSize, -1);
        a.recycle();
        return actionBarSize;
    }
}
