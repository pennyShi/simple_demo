package com.idreamo.rrtoyewx.smipledemo.utils;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by rrtoyewx on 15/8/25.
 */
public class CommonUtils {
    public static int dpToPx(Resources res, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, res.getDisplayMetrics());
    }
}
