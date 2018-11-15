package com.example.mvpdemo.mvedemo;

import android.app.Application;
import android.os.Handler;

public class MvpApplication extends Application {
    private static Handler mainThreadHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        mainThreadHandler = new Handler();
    }

    public static Handler getMainThreadHandler() {
        return mainThreadHandler;
    }
}
