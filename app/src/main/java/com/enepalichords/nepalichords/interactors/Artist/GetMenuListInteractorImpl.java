package com.enepalichords.nepalichords.interactors.Artist;

import com.enepalichords.nepalichords.Data.DataRepository;
import com.enepalichords.nepalichords.Data.Model.Menu;
import com.enepalichords.nepalichords.executor.Executor;
import com.enepalichords.nepalichords.executor.Interactor;
import com.enepalichords.nepalichords.executor.MainThread;

import java.util.List;

import javax.inject.Inject;


/**
 * Created by sameer on 3/9/15.
 */
public class GetMenuListInteractorImpl implements Interactor, GetMenuListInteractor {

    private final DataRepository dataRepository;
    private final Executor executor;
    private final MainThread mainThread;
    private Callback callback;

    @Inject
    public GetMenuListInteractorImpl(DataRepository dataRepository, Executor executor, MainThread mainThread) {
        this.dataRepository = dataRepository;
        this.executor = executor;
        this.mainThread = mainThread;
    }

    @Override
    public void Execute(Callback callback) {
        if (callback != null)
        {
            this.callback = callback;
            this.executor.run(this);
        }
    }

    @Override
    public void run() {
        List<Menu> menus = dataRepository.getMenuList();
        notifyMenuListGenerated(menus);
    }

    private void notifyMenuListGenerated(final List<Menu> menus) {
        mainThread.post(new Runnable() {
            @Override
            public void run() {
                callback.OnMenuListCreated(menus);
            }
        });
    }


}
