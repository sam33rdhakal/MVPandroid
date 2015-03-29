package com.enepalichords.nepalichords.UI.ArtistInformation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enepalichords.nepalichords.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by sameer on 3/15/15.
 */
public class SongDetailFragment extends Fragment {

    public static final String TAG = "SongDetailFragment";



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.song_details_fragment, container, false);
        ButterKnife.inject(this, layout);
        return layout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public void onDestroy() {
        ButterKnife.reset(this);
        super.onDestroy();
    }


}
