package com.jwang.android.demo;

import android.app.Application;
import android.content.Context;

/**
 * Created by jiajunwang on 8/28/15.
 */
public class DemoApp extends Application
{
    private static DemoApp sInstance;
    private Context mContext;

    public DemoApp()
    {
        super();
        sInstance = this;
    }

    public static DemoApp getInstance()
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
