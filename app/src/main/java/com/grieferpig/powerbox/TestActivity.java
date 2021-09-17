package com.grieferpig.powerbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.grieferpig.powerbox.utils.DisplayUtil;
import com.grieferpig.powerbox.utils.RebootUtil;
import com.grieferpig.powerbox.utils.RootUtil;
import com.grieferpig.powerbox.utils.ScreenCapUtil;
import com.grieferpig.powerbox.utils.ThreadWrapper;

public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void setres(View v){
        new ThreadWrapper(new Runnable() {
            @Override
            public void run() {
                DisplayUtil.setResolution("480", "540");
            }
        });
    }

    public void resetboth(View v){
        new ThreadWrapper(new Runnable() {
            @Override
            public void run() {
                DisplayUtil.resetResolution();
                DisplayUtil.resetDensity();
            }
        });
    }

    public void setdens(View v){
        new ThreadWrapper(new Runnable() {
            @Override
            public void run() {
                DisplayUtil.setDensity("200");
            }
        });
    }

    public void rebootrec(View v){
        new ThreadWrapper(new Runnable() {
            @Override
            public void run() {
                RebootUtil.rebootRec();
            }
        });
    }

    public void detectroot(View v){
        new ThreadWrapper(new Runnable() {
            @Override
            public void run() {
                RootUtil.detectRootAccessPopped();
            }
        });
    }

    public void scrcap(View v) {
        new ThreadWrapper(new Runnable() {
            @Override
            public void run() {
                ScreenCapUtil.capture();
            }
        });
    }

}