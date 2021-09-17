package com.grieferpig.powerbox.utils;

import com.grieferpig.powerbox.config;

public class ScreenCapUtil {

    final private static Object _lock = new Object();

    final public static String tmpCapFilename = "wdnmdnmsl.png";
    final public static String tmpCapFilePath = config.TMP_FOLDER + tmpCapFilename;

    public static boolean capture(){
        ShellWrapper.exec(false, "screencap -p " + config.TMP_FOLDER + tmpCapFilename);
        return FileUtil.exists(tmpCapFilePath);
    }
}
