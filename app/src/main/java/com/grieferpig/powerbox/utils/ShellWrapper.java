package com.grieferpig.powerbox.utils;

import com.grieferpig.powerbox.R;
import com.grieferpig.powerbox.visuals.ToastWrapper;
import com.stericson.RootShell.RootShell;
import com.stericson.RootShell.exceptions.RootDeniedException;
import com.stericson.RootShell.execution.Command;
import com.stericson.RootShell.execution.Shell;

import java.util.concurrent.TimeoutException;

public class ShellWrapper {

    private static Shell _s;

    final public static int UNKNOWNEXCEPTION = -247;
    final public static int TIMEOUTEXCEPTION = 593;
    final public static int ROOTDENIEDEXCEPTION = -4;
    final public static int OKAY = 0;

    public static int exec(boolean asroot, String[] cmdarray){
        try {
            _s = RootShell.getShell(asroot);
            Command command = new Command(0, cmdarray);
            _s.add(command);
        }catch(TimeoutException te){
            ToastWrapper.show(i18Util.get(R.string.toast_timeout_exception));
            return TIMEOUTEXCEPTION;
        }catch(RootDeniedException rde){
            ToastWrapper.show(i18Util.get(R.string.toast_app_root_access_failed));
            return ROOTDENIEDEXCEPTION;
        }catch(Exception e){
            ToastWrapper.show(i18Util.get(R.string.toast_unknown_exception));
            return UNKNOWNEXCEPTION;
        }
        return OKAY;
    }

    public static int exec(boolean asroot, String cmd){
        try {
            _s = RootShell.getShell(asroot);
            Command command = new Command(0, cmd);
            _s.add(command);
        }catch(TimeoutException te){
            ToastWrapper.show(i18Util.get(R.string.toast_timeout_exception));
            return TIMEOUTEXCEPTION;
        }catch(RootDeniedException rde){
            ToastWrapper.show(i18Util.get(R.string.toast_app_root_access_failed));
            return ROOTDENIEDEXCEPTION;
        }catch(Exception e){
            ToastWrapper.show(i18Util.get(R.string.toast_unknown_exception));
            return UNKNOWNEXCEPTION;
        }
        return OKAY;
    }
}
