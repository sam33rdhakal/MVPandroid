package com.enepalichords.nepalichords.UI.Home;

/**
 * Created by sameer on 3/4/15.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enepalichords.nepalichords.Data.Model.Artist;
import com.enepalichords.nepalichords.R;

import java.util.List;

import javax.inject.Inject;


public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.MenuViewHolder> {

    private LayoutInflater inflater;
    private List<Artist> artists;


    public RecyclerViewAdaptor(Context context, List<Artist> artists) {
        this.inflater = LayoutInflater.from(context);
        this.artists = artists;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = inflater.inflate(R.layout.navigation_menu, viewGroup, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder menuViewHolder, int position) {
        Artist artist = artists.get(position);
        menuViewHolder.title.setText(artist.name);
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView icon;

        public MenuViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.menuText);

        }
    }
}
