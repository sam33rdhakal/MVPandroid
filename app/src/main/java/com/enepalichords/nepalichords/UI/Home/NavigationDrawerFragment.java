package com.enepalichords.nepalichords.UI.Home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.enepalichords.nepalichords.Data.Model.Artist;
import com.enepalichords.nepalichords.R;

import java.util.List;


/**
 * Created by sameer on 3/4/15.
 */

public class NavigationDrawerFragment extends Fragment {


    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private View containerView;
    private RecyclerView recyclerView;
    private RecyclerViewAdaptor recyclerViewAdaptor;
    List<Artist> artists;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast.makeText(getActivity(), " on create view fragment", Toast.LENGTH_LONG).show();
        View layout = inflater.inflate(R.layout.navigation_fragment, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.drawerlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return layout;
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout, Toolbar toolbar, List<Artist> _artists) {

        this.artists = _artists;

        Toast.makeText(getActivity(), " First items loaded", Toast.LENGTH_LONG).show();

        //TODO
        //recyclerViewAdaptor needs assisted injection

        recyclerViewAdaptor = new RecyclerViewAdaptor(getActivity(), artists);
        recyclerView.setAdapter(recyclerViewAdaptor);

        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }

    //add new artist to menu
    public void updateMenuList(Artist artist) {
        this.artists.add(artist);
        Toast.makeText(getActivity(), "Updating list", Toast.LENGTH_LONG).show();
        recyclerViewAdaptor.notifyItemInserted(artists.size());
    }
}
