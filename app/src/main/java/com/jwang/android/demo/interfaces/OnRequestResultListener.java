package com.jwang.android.demo.interfaces;

import java.util.ArrayList;

/**
 * Created by jiajunwang on 8/28/15.
 */
public interface OnRequestResultListener
{
    public static final OnRequestResultListener NO_OP = new OnRequestResultListener()
    {
        @Override
        public void onResult(ArrayList<String> arrayList)
        {
        }
    };

    public void onResult(ArrayList<String> arrayList);
}
