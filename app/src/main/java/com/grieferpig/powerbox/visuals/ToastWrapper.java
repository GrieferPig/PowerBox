package com.grieferpig.powerbox.visuals;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.grieferpig.powerbox.utils.ContextProvider;

public class ToastWrapper extends ContextProvider {

    public static void show(String message){
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(_a, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
