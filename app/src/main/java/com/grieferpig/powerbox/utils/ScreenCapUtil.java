package com.grieferpig.powerbox.utils;

import android.annotation.SuppressLint;

import com.grieferpig.powerbox.config;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenCapUtil {

    final private static Object _lock = new Object();

    //final public static String tmpCapFilename = "wdnmdnmsl.png";
    //final public static String tmpCapFilePath = config.TMP_FOLDER + tmpCapFilename;

    public static String getCurrentTimeStamp(){
        try {

            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentDateTime = dateFormat.format(new Date()); // Find todays date

            return currentDateTime;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean capture(){
        String tmpCapFilename = "scr_"+getCurrentTimeStamp();
        String tmpCapFilePath = config.TMP_FOLDER + tmpCapFilename;
        ShellWrapper.exec(false, "screencap -p " + config.TMP_FOLDER + tmpCapFilename);
        return FileUtil.exists(tmpCapFilePath);
    }
}
