package com.jwang.android.pinterestdemo.task;

import java.util.ArrayList;

import android.content.Context;
import android.os.AsyncTask;

import com.jwang.android.pinterestdemo.interfaces.OnRequestWeatherResultListener;
import com.jwang.android.pinterestdemo.util.HttpRequestResultUtil;
import com.jwang.android.pinterestdemo.util.HttpRequestUtil;

/**
 * Created by jiajunwang on 9/1/15.
 */
public class FetchWeatherTask extends
        AsyncTask<String, Void, ArrayList<String>>
{
    private static final String TAG = FetchWeatherTask.class.getSimpleName();
    private static final String URL = "http://api.openweathermap.org/data/2.5/forecast?q=London,us&mode=json";

    private Context mContext;
    private OnRequestWeatherResultListener mOnRequestWeatherResultListener = OnRequestWeatherResultListener.NO_OP;

    public FetchWeatherTask(Context context)
    {
        mContext = context;
    }

    public void setOnRequestPinResultListener(OnRequestWeatherResultListener listener)
    {
        mOnRequestWeatherResultListener = listener;
    }

    @Override
    protected ArrayList<String> doInBackground(String... strings)
    {
        String pinResponse = HttpRequestUtil.startHttpRequest(URL, TAG);
        return HttpRequestResultUtil.parseWeatherJsonObject(pinResponse);
    }

    @Override
    protected void onPostExecute(ArrayList<String> strings)
    {
        super.onPostExecute(strings);
        mOnRequestWeatherResultListener.onResult(strings);
    }
}
