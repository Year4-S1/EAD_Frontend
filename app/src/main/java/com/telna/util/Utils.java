package com.telna.util;

import android.content.Context;
import android.widget.Switch;
import android.widget.Toast;

public class Utils {
    private static Toast toast;
    public static void showToast(String text, Context context) {
        if (toast == null) {
            toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
        }
        toast.setText(text);
        toast.show();
    }
}
