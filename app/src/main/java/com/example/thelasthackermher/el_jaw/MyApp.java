package com.example.thelasthackermher.el_jaw;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by thelasthackermher on 25/11/15.
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
