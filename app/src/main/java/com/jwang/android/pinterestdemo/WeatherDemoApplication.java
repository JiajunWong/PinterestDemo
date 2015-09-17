package com.jwang.android.pinterestdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by jiajunwang on 8/28/15.
 */
public class WeatherDemoApplication extends Application
{
    private static WeatherDemoApplication sInstance;
    private Context mContext;

    public WeatherDemoApplication()
    {
        super();
        sInstance = this;
    }

    public static WeatherDemoApplication getInstance()
    {
        return sInstance;
    }

    public static Context getContext()
    {
        return getInstance().mContext;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
