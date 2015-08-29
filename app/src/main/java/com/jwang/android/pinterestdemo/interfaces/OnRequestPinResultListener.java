package com.jwang.android.pinterestdemo.interfaces;

import com.jwang.android.pinterestdemo.model.ModelPin;

import java.util.ArrayList;

/**
 * Created by jiajunwang on 8/28/15.
 */
public interface OnRequestPinResultListener
{
    public static final OnRequestPinResultListener NO_OP = new OnRequestPinResultListener()
    {
        @Override
        public void onResult(ArrayList<ModelPin> arrayList)
        {
        }
    };

    public void onResult(ArrayList<ModelPin> arrayList);
}
