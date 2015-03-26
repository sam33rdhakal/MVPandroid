package com.enepalichords.nepalichords.UI.ArtistInformation;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.enepalichords.nepalichords.Data.Model.Artist;
import com.enepalichords.nepalichords.Data.Model.Song;
import com.enepalichords.nepalichords.R;
import com.enepalichords.nepalichords.UI.ArtistInformation.Adaptor.SongsAdaptor;
import com.enepalichords.nepalichords.UI.ArtistInformation.fragments.SongDetailFragment;
import com.enepalichords.nepalichords.UI.Common.RecyclerViewTouchListener;
import com.enepalichords.nepalichords.UI.Common.Utils.Utils;
import com.enepalichords.nepalichords.UI.Common.View.BaseActivity;
import com.enepalichords.nepalichords.UI.Common.View.SimpleDividerItemDecoration;
import com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.ViewHelper;
import com.pkmmte.view.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class ArtistInformationActivity extends BaseActivity implements ArtistInformationView, ObservableScrollViewCallbacks {


    private static final String STATE_SONGS = "song_list";
    private static final String STATE_ARTIST = "song_artist";
    private boolean isToolbarVisible;
    private final String TOOLBAR_STATE = "toolbar_state";

    @InjectView(R.id.toolbar_view) Toolbar mToolbarView;
    @InjectView(R.id.scroll) ObservableRecyclerView songsRecyclerView;

    @Inject ArtistInformationPresenter artistInformationPresenter;
    @Inject SongDetailFragment songDetailFragment;

    private Artist currentArtist = new Artist();
    private SongsAdaptor songsAdaptor;
    private List<Song> songs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_information);
        ButterKnife.inject(this);


        setSupportActionBar(mToolbarView);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        initializeView();


        if (savedInstanceState == null)
        {
            isToolbarVisible = true;
            artistInformationPresenter.getArtistSongs(1);
            currentArtist = (Artist) this.getIntent().getExtras().get("example");

        } else
        {
            isToolbarVisible = savedInstanceState.getBoolean(TOOLBAR_STATE);
            currentArtist = savedInstanceState.getParcelable(STATE_ARTIST);
            songs = savedInstanceState.getParcelableArrayList(STATE_SONGS);
            LoadArtistDetails(songs);
        }

        if (isToolbarVisible)
        {
            mToolbarView.setVisibility(View.VISIBLE);
        } else
        {
            mToolbarView.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void displayMessage() {
        Utils.ShowToastMessage(this, "Server Loading...");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(STATE_ARTIST, currentArtist);
        outState.putParcelableArrayList(STATE_SONGS, (ArrayList) songs);
        outState.putBoolean(TOOLBAR_STATE, isToolbarVisible);
    }


    public List<Object> getModules() {
        LinkedList<Object> modules = new LinkedList<>();
        modules.add(new ArtistInformationModule(this));
        return modules;
    }

    private void initializeView() {


        //set scroll listener
        songsRecyclerView.setScrollViewCallbacks(this);

        //initialize recyclerView
        songsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        songsRecyclerView.setHasFixedSize(false);
        songsRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(
                getApplicationContext()
        ));

        //set recyclerView click listener
        songsRecyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(this, songsRecyclerView, new RecyclerViewTouchListener.ClickListener() {
            @Override
            public void onClick(View v, int position) {
                LoadSongFragment(position);
            }
        }));

        final View contentView = getWindow().getDecorView().findViewById(android.R.id.content);


    }

    @Override
    public void LoadArtistDetails(List<Song> songs) {
        this.songs = songs;
        //draw header for recycler view
        final View headerView = LayoutInflater.from(this).inflate(R.layout.recycler_header, null);
        // load artist cover image and name
        Picasso.with(this).load(currentArtist.avatar).into((CircularImageView) headerView.findViewById(R.id.coverImage));
        TextView txtArtist = (TextView) headerView.findViewById(R.id.artistText);
        txtArtist.setText(currentArtist.name);
        getSupportActionBar().setTitle(currentArtist.name);
        // set adaptor
        songsAdaptor = new SongsAdaptor(this, songs, headerView);
        songsRecyclerView.setAdapter(songsAdaptor);
    }


    private void LoadSongFragment(int songId) {
//        addFragment(android.R.id.content, songDetailFragment, SongDetailFragment.TAG);
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {

    }

    @Override
    public void onDownMotionEvent() {
    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
        if (scrollState == ScrollState.UP)
        {
            if (isToolbarVisible)
            {
                hideToolbar();
                isToolbarVisible = false;
            }
        } else if (scrollState == ScrollState.DOWN)
        {
            if (!isToolbarVisible)
            {
                showToolbar();
                isToolbarVisible = true;
            }
        }
    }

    private void showToolbar() {
        moveToolbar(0);
    }

    private void hideToolbar() {
        moveToolbar(-mToolbarView.getHeight());
    }

    private void moveToolbar(float toTranslationY) {
        if (ViewHelper.getTranslationY(mToolbarView) == toTranslationY)
        {
            return;
        }
        ValueAnimator animator = ValueAnimator.ofFloat(ViewHelper.getTranslationY(mToolbarView), toTranslationY).setDuration(200);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float translationY = (float) animation.getAnimatedValue();
                ViewHelper.setTranslationY(mToolbarView, translationY);
            }
        });
        animator.start();
    }
}