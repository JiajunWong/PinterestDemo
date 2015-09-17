package com.jwang.android.demo.interfaces;

import java.util.ArrayList;

/**
 * Created by jiajunwang on 8/28/15.
 */
public interface OnRequestWeatherResultListener
{
    public static final OnRequestWeatherResultListener NO_OP = new OnRequestWeatherResultListener()
    {
        @Override
        public void onResult(ArrayList<String> arrayList)
        {
        }
    };

    public void onResult(ArrayList<String> arrayList);
}
