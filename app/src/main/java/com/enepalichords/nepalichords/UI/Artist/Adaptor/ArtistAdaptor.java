package com.enepalichords.nepalichords.UI.Artist.Adaptor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.enepalichords.nepalichords.Data.Model.Artist;
import com.enepalichords.nepalichords.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by sameer on 3/11/15.
 */
public class ArtistAdaptor extends RecyclerView.Adapter<ArtistAdaptor.ArtistViewHolder> {

    private List<Artist> artists;
    private Context context;


    public ArtistAdaptor(Context context, List<Artist> artists) {
        this.context = context;
        this.artists = artists;
    }

    @Override
    public ArtistViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_artist, viewGroup, false);
        return new ArtistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArtistViewHolder ArtistViewHolder, int position) {
        Artist artist = artists.get(position);
        ArtistViewHolder.title.setText(artist.name);
        Picasso.with(context).load(artist.avatar).into(ArtistViewHolder.avatar);
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public class ArtistViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.artistName) TextView title;
        @InjectView(R.id.artistImage) ImageView avatar;

        public ArtistViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }
}
