package com.nctu.nctuplus.nctuplus.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by cober on 2015/12/4.
 */
public class ToastUtil {
    public static void shortToast(Context context, String message) {
        Toast toast = Toast.makeText(context, message,
                Toast.LENGTH_SHORT);
        toast.show();
    }
}