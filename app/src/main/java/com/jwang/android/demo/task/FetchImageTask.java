package com.jwang.android.demo.task;

import java.util.ArrayList;

import android.content.Context;
import android.os.AsyncTask;

import com.jwang.android.demo.interfaces.OnRequestResultListener;
import com.jwang.android.demo.util.HttpRequestResultUtil;
import com.jwang.android.demo.util.HttpRequestUtil;

/**
 * Created by jiajunwang on 9/1/15.
 */
public class FetchImageTask extends
        AsyncTask<String, Void, ArrayList<String>>
{
    private static final String TAG = FetchImageTask.class.getSimpleName();
    private static final String URL = "http://api.openweathermap.org/data/2.5/forecast?q=London,us&mode=json";

    private Context mContext;
    private OnRequestResultListener mOnRequestResultListener = OnRequestResultListener.NO_OP;

    public FetchImageTask(Context context)
    {
        mContext = context;
    }

    public void setOnRequestPinResultListener(OnRequestResultListener listener)
    {
        mOnRequestResultListener = listener;
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
        mOnRequestResultListener.onResult(strings);
    }
}
