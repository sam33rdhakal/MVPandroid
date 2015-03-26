package com.enepalichords.nepalichords.UI.Common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;


/**
 * Created by sameer on 3/12/15.
 */
public class RecyclerViewTouchListener implements RecyclerView.OnItemTouchListener {

    GestureDetector gestureDetector;
    ClickListener clickListener;
    Context context;
    RecyclerView recyclerView;

    public RecyclerViewTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.clickListener = clickListener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                clickListener.onClick(child, recyclerView.getChildPosition(child));
                return super.onSingleTapUp(e);
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        View child = recyclerView.findChildViewUnder(e.getX(), e.getY());

        if (child != null && clickListener != null)
        {
            gestureDetector.onTouchEvent(e);
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
    }

    public interface ClickListener {

        public void onClick(View v, int position);
    }
}