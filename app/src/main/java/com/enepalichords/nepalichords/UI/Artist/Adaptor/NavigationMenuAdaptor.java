package com.enepalichords.nepalichords.UI.Artist.Adaptor;

/**
 * Created by sameer on 3/4/15.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.enepalichords.nepalichords.Data.Model.Menu;
import com.enepalichords.nepalichords.R;
import com.enepalichords.nepalichords.UI.Common.Utils.Utils;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class NavigationMenuAdaptor extends RecyclerView.Adapter<NavigationMenuAdaptor.MenuViewHolder> {


    private List<Menu> menus;
    private Context context;

    public NavigationMenuAdaptor(Context context, List<Menu> menus) {
        this.context = context;
        this.menus = menus;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.navigation_menu, viewGroup, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder menuViewHolder, int position) {
        Menu menu = menus.get(position);
        menuViewHolder.title.setText(menu.item);
        int resourceId = Utils.getResourceId(context, menu.icon, "drawable", context.getPackageName());
        menuViewHolder.icon.setImageResource(resourceId);
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.menuText) TextView title;
        @InjectView(R.id.menuIcon) ImageView icon;

        public MenuViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }
}
