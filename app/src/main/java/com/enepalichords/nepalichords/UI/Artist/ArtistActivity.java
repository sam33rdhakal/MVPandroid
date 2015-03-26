package com.enepalichords.nepalichords.UI.Artist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.enepalichords.nepalichords.Data.Model.Artist;
import com.enepalichords.nepalichords.Data.Model.Menu;
import com.enepalichords.nepalichords.R;
import com.enepalichords.nepalichords.UI.Artist.Adaptor.ArtistAdaptor;
import com.enepalichords.nepalichords.UI.Artist.fragments.NavigationDrawerFragment;
import com.enepalichords.nepalichords.UI.ArtistInformation.ArtistInformationActivity;
import com.enepalichords.nepalichords.UI.Common.RecyclerViewTouchListener;
import com.enepalichords.nepalichords.UI.Common.Utils.Utils;
import com.enepalichords.nepalichords.UI.Common.View.BaseActivity;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class ArtistActivity extends BaseActivity implements ArtistView, NavigationDrawerFragment.Callback {


    @InjectView(R.id.toolbar_view) Toolbar toolbar;
    @InjectView(R.id.artistRecyclerView) RecyclerView artistRecyclerView;

    @Inject NavigationDrawerFragment navigationDrawerFragment;
    @Inject ArtistPresenter artistPresenter;

    private ArtistAdaptor artistAdaptor;
    private List<Artist> artists;
    private int itemsInRow;
    private long mScreenWidth;

    @Override
    public List<Object> getModules() {
        LinkedList<Object> modules = new LinkedList<>();
        modules.add(new ArtistModule(this));
        return modules;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.inject(this);
        mScreenWidth = getWindowManager().getDefaultDisplay().getWidth();
        initializeView();
        artistPresenter.getArtistList();
        artistPresenter.getMenuList();
        Utils.ShowToastMessage(this, mScreenWidth + "");
    }

    @Override
    public void loadArtistList(List<Artist> artists) {
        this.artists = artists;
        artistAdaptor = new ArtistAdaptor(this, artists);
        artistRecyclerView.setAdapter(artistAdaptor);
    }

    @Override
    public void loadMenuList(List<Menu> menus) {
        navigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        navigationDrawerFragment.setUp((DrawerLayout) findViewById(R.id.drawer_layout), toolbar, menus);
    }

    protected void initializeView() {
        //set the toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //initialize recyclerView
        //set spanCount 3 if it is not phone
        itemsInRow = (mScreenWidth <= 1080) ? 2 : 3;
        Utils.ShowToastMessage(this, mScreenWidth + " & spanCount =" + itemsInRow);
        artistRecyclerView.setLayoutManager(new GridLayoutManager(this, itemsInRow));
        artistRecyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(this, artistRecyclerView, new RecyclerViewTouchListener.ClickListener() {
            @Override
            public void onClick(View v, int position) {
                loadArtistDetails(artists.get(position));
            }
        }));
    }

    //handle menu click
    @Override
    public void menuItemClick(Menu menu) {
        Utils.ShowToastMessage(this, menu.item + " clicked");
        if (menu.item == "About")
        {
            new MaterialDialog.Builder(this)
                    .title(R.string.about_dialog_box_title)
                    .content(R.string.about_dialog_box_content)
                    .positiveText(R.string.agree)
                    .show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.reset(this);
    }

    @Override
    public void loadArtistDetails(Artist artist) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("example", artist);
        Intent intent = new Intent(this, ArtistInformationActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

