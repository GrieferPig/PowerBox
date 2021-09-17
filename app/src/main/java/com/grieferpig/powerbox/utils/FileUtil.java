package com.grieferpig.powerbox.utils;

import com.stericson.RootTools.RootTools;

public class FileUtil {
    public static boolean exists(String file){
        return RootTools.exists(file);
    }

    public static boolean existsDir(String file){
        return RootTools.exists(file, true);
    }

    public static boolean copyFile(String src, String dest){
        RootTools.copyFile(src, dest, false, true);
        return exists(dest);
    }

    public static boolean copyFile(String src, String dest, boolean remount){
        RootTools.copyFile(src, dest, remount, true);
        return exists(dest);
    }


}
