package com.grieferpig.powerbox.utils;

public class DisplayUtil {
    public static int setResolution(String width, String height){
        return ShellWrapper.exec(false, "wm size " + width + "x" + height);
    }

    public static int resetResolution(){
        return ShellWrapper.exec(false, "wm size reset");
    }

    public static int setDensity(String density){
        return ShellWrapper.exec(false, "wm density "+ density);
    }

    public static int resetDensity(){
        return ShellWrapper.exec(false, "wm density reset");
    }
}
