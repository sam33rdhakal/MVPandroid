package com.enepalichords.nepalichords.interactors.Artist;

import com.enepalichords.nepalichords.Data.Model.Menu;

import java.util.List;


/**
 * Created by sameer on 3/9/15.
 */
public interface GetMenuListInteractor {

    interface Callback {

         void OnMenuListCreated(final List<Menu> menus);

         void onError();
    }

    public void Execute(Callback callback);
}
