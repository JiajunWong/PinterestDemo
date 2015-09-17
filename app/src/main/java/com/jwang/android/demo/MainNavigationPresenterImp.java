package com.jwang.android.demo;

import android.content.Context;

import com.jwang.android.demo.interfaces.MainNavigationPresenter;
import com.jwang.android.demo.interfaces.MainNavigationView;
import com.jwang.android.demo.interfaces.OnRequestResultListener;
import com.jwang.android.demo.task.FetchImageTask;

import java.util.ArrayList;

/**
 * Created by Jiajun Wang on 9/17/15.
 * Copyright (c) 2015 Tank Exchange, Inc. All rights reserved.
 */
public class MainNavigationPresenterImp implements MainNavigationPresenter,
        OnRequestResultListener
{
    private MainNavigationView mMainNavigationView;
    private FetchImageTask mFetchImageTask;

    public MainNavigationPresenterImp(Context context, MainNavigationView mainNavigationView)
    {
        mFetchImageTask = new FetchImageTask(context);
        mMainNavigationView = mainNavigationView;
    }

    @Override
    public void onResume()
    {
        mFetchImageTask.setOnRequestPinResultListener(this);
        mFetchImageTask.execute();
    }

    @Override
    public void onResult(ArrayList<String> arrayList)
    {
        mMainNavigationView.setItem(arrayList);
    }
}
