package com.grieferpig.powerbox.utils;

import android.util.Log;

import com.grieferpig.powerbox.R;
import com.grieferpig.powerbox.visuals.ToastWrapper;
import com.stericson.RootShell.exceptions.RootDeniedException;
import com.stericson.RootShell.execution.Command;
import com.stericson.RootShell.execution.Shell;

import java.util.concurrent.TimeoutException;

public class ShellWrapper {

    private static Shell _s;

    final public static int UNKNOWNEXCEPTION = -24532;
    final public static int TIMEOUTEXCEPTION = -39393;
    final public static int ROOTDENIEDEXCEPTION = -69320;

    public static int exec(boolean asroot, String[] cmdarray){
        int _exitCode = 0;
        try {
            Command _c = new Command(0, cmdarray);
            Shell.runRootCommand(_c);
            waitForCommand(_c);
            _exitCode = _c.getExitCode();
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
        return _exitCode;
    }


    public static int exec(boolean asroot, String cmd){
        int _exitCode = 0;
        try {
            Command _c = new Command(0, cmd);
            Shell.runRootCommand(_c);
            waitForCommand(_c);
            _exitCode = _c.getExitCode();
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
        return _exitCode;
    }

    private static void waitForCommand(Command cmd) {
        while (!cmd.isFinished()) {
            synchronized (cmd) {
                try {
                    if (!cmd.isFinished()) {
                        cmd.wait(500);
                        Log.d("TAG", "waitForCommand: ");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!cmd.isExecuting() &&!cmd.isFinished()) {
                return;
            }
        }
    }
}
