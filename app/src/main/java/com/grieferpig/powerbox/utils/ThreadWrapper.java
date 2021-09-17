package com.grieferpig.powerbox.utils;

public class ThreadWrapper{

    private Thread _t;

    public ThreadWrapper(Runnable run){
        _t = new Thread(run);
        _t.start();
    }

    public Thread getThread(){
        return _t;
    }
}
