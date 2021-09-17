package com.grieferpig.powerbox.utils;

import android.util.Log;

import com.grieferpig.powerbox.R;
import com.stericson.RootTools.*;
import com.grieferpig.powerbox.visuals.ToastWrapper;

public class RootUtil {

    public final static int ACCESS_GIVEN = 0;
    public final static int ACCESS_DENIED = -1;
    public final static int NO_ACCESS = -114;

    public static int detectRootAccess(){
        if (RootTools.isRootAvailable()) {
            if (RootTools.isAccessGiven()) {
                return ACCESS_GIVEN;
            }
            return ACCESS_DENIED;
        }
        return NO_ACCESS;
    }

    public static void detectRootAccessLogged() {
        int _result = detectRootAccess();
        LogUtil _log = new LogUtil(LogUtil.INFO);
        switch (_result) {
            case ACCESS_GIVEN:
                _log.a(i18Util.get(R.string.toast_root_access_ok));
                break;

            case ACCESS_DENIED:
                _log.a(i18Util.get(R.string.toast_root_access_denied));
                break;

            case NO_ACCESS:
                _log.a(i18Util.get(R.string.toast_root_access_failed));
                break;
        }
    }

    public static void detectRootAccessPopped() {
        int _result = detectRootAccess();
        switch (_result) {
            case ACCESS_GIVEN:
                ToastWrapper.show(i18Util.get(R.string.toast_root_access_ok));
                break;

            case ACCESS_DENIED:
                ToastWrapper.show(i18Util.get(R.string.toast_root_access_denied));
                break;

            case NO_ACCESS:
                ToastWrapper.show(i18Util.get(R.string.toast_root_access_failed));
                break;
        }
    }

    public static void rootDenied(){
        ToastWrapper.show(i18Util.get(R.string.toast_app_root_access_failed));
    }
}
