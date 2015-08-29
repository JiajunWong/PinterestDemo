package com.jwang.android.pinterestdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by jiajunwang on 8/28/15.
 */
public class PinterestDemoApplication extends Application
{
    private static PinterestDemoApplication sInstance;
    private Context mContext;

    public PinterestDemoApplication()
    {
        super();
        sInstance = this;
    }

    public static PinterestDemoApplication getInstance()
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
