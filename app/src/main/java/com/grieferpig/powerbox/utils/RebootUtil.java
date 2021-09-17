package com.grieferpig.powerbox.utils;

public class RebootUtil {
    public static int rebootRec(){
        return ShellWrapper.exec(true,"reboot recovery");
    }

    public static int rebootEdl(){
        return ShellWrapper.exec(true,"reboot edl");
    }

    public static int rebootBl(){
        return ShellWrapper.exec(true,"reboot bootloader");
    }
}
