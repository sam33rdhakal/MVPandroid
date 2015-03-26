package com.enepalichords.nepalichords.UI.Common.View;

import android.app.Activity;
import android.support.v4.app.Fragment;


/**
 * Created by sameer on 2/28/15.
 */
public class BaseFragment extends Fragment {

    @Override public void onAttach(Activity activity) {
        super.onAttach(activity);
        injectDependencies();
    }

    private void injectDependencies() {
        ((BaseActivity) getActivity()).inject(this);
    }
}
