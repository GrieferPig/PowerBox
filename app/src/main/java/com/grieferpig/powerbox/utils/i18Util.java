package com.grieferpig.powerbox.utils;

import androidx.annotation.StringRes;

public class i18Util extends ContextProvider{
    public static String get(@StringRes int resId){
        return _a.getString(resId);
    }
}
