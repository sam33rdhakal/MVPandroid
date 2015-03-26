package com.enepalichords.nepalichords.UI.ArtistInformation.Adaptor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enepalichords.nepalichords.Data.Model.Song;
import com.enepalichords.nepalichords.R;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by sameer on 3/15/15.
 */
public class SongsAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<Song> songs;
    private LayoutInflater mInflater;
    private View mHeaderView;

    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_ITEM = 1;

    public SongsAdaptor(Context context, List<Song> songs, View headerView) {
        this.mInflater = LayoutInflater.from(context);
        this.mHeaderView = headerView;
        this.songs = songs;
    }

    @Override
    public int getItemCount() {
        if (mHeaderView == null)
        {
            return songs.size();
        } else
        {
            return songs.size() + 1;
        }

    }

    @Override
    public int getItemViewType(int position) {
        return (position == 0) ? VIEW_TYPE_HEADER : VIEW_TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        if (position == VIEW_TYPE_HEADER)
        {
            return new HeaderViewHolder(mHeaderView);
        } else
        {
            View view = mInflater.inflate(R.layout.song_list_item, viewGroup, false);
            return new SongViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof SongViewHolder)
        {
            Song song = songs.get(position - 1);
            ((SongViewHolder) viewHolder).songtitle.setText(song.title);
        }

    }


    static class SongViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.songTitle) TextView songtitle;

        public SongViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {

        public HeaderViewHolder(View view) {
            super(view);
        }
    }
}
