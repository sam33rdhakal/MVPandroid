package com.enepalichords.nepalichords.UI.Artist.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enepalichords.nepalichords.Data.Model.Menu;
import com.enepalichords.nepalichords.R;
import com.enepalichords.nepalichords.UI.Artist.Adaptor.NavigationMenuAdaptor;
import com.enepalichords.nepalichords.UI.Common.RecyclerViewTouchListener;
import com.enepalichords.nepalichords.UI.Common.View.BaseFragment;
import com.enepalichords.nepalichords.UI.Common.View.SimpleDividerItemDecoration;

import java.util.List;


/**
 * Created by sameer on 3/4/15.
 */

public class NavigationDrawerFragment extends BaseFragment {

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private RecyclerView recyclerView;
    private NavigationMenuAdaptor navigationMenuAdaptor;
    private Callback callback;
    List<Menu> menus;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.callback = (Callback) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.navigation_fragment, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.drawerlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(getActivity(), recyclerView, new RecyclerViewTouchListener.ClickListener() {
            @Override
            public void onClick(View v, int position) {
                callback.menuItemClick(menus.get(position));
            }
        }));
        return layout;
    }

    public void setUp(DrawerLayout drawerLayout, Toolbar toolbar, List<Menu> _menus) {
        this.menus = _menus;
        navigationMenuAdaptor = new NavigationMenuAdaptor(getActivity(), menus);
        recyclerView.setAdapter(navigationMenuAdaptor);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(
                getActivity().getApplicationContext()
        ));
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

    public interface Callback {

        public void menuItemClick(Menu menu);
    }

}