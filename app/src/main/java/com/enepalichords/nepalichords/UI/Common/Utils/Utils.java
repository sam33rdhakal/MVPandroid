package com.enepalichords.nepalichords.UI.Common.Utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;


/**
 * Created by sameer on 3/5/15.
 */
public class Utils {

    public static final String TAG = "NepaliChords";

    public static void hide_keyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null)
        {
            view = new View(activity);
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static int getResourceId(Context context, String pVariableName, String pResourcename, String pPackageName) {
        try
        {
            return context.getResources().getIdentifier(pVariableName, pResourcename, pPackageName);
        } catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }

    public static void ShowToastMessage(Context context, String message) {
//        int time = (duration == 1) ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT;
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void LogMessage(String message) {
        Log.d(TAG, message);
    }

}
