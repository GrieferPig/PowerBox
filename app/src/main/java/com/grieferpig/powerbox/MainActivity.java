package com.grieferpig.powerbox;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {


    private static Context instance;

    public static Context getContext()
    {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = getApplicationContext();
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this, TestActivity.class));
    }
}