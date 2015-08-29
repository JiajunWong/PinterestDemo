package com.jwang.android.pinterestdemo.task;

import android.content.Context;
import android.os.AsyncTask;

import com.jwang.android.pinterestdemo.interfaces.OnRequestPinResultListener;
import com.jwang.android.pinterestdemo.model.ModelPin;
import com.jwang.android.pinterestdemo.util.HttpRequestResultUtil;
import com.jwang.android.pinterestdemo.util.HttpRequestUtil;

import java.util.ArrayList;

/**
 * Created by jiajunwang on 8/28/15.
 */
public class RequestUserPinTask extends
        AsyncTask<String, Void, ArrayList<ModelPin>>
{
    private static final String TAG = RequestUserPinTask.class.getSimpleName();
    private Context mContext;
    private OnRequestPinResultListener mOnRequestPinResultListener = OnRequestPinResultListener.NO_OP;

    public RequestUserPinTask(Context context)
    {
        mContext = context;
    }

    public void setOnRequestPinResultListener(OnRequestPinResultListener listener)
    {
        mOnRequestPinResultListener = listener;
    }

    @Override
    protected ArrayList<ModelPin> doInBackground(String... params)
    {
        ArrayList<ModelPin> result = new ArrayList<>();
        if (params == null || params.length == 0)
        {
            return result;
        }

        String url = buildPinUrl(params[0]);
        String pinResponse = HttpRequestUtil.startHttpRequest(url, TAG);
        return HttpRequestResultUtil.parsePinJsonObject(pinResponse);
    }

    @Override
    protected void onPostExecute(ArrayList<ModelPin> modelPins)
    {
        super.onPostExecute(modelPins);
        mOnRequestPinResultListener.onResult(modelPins);
    }

    private String buildPinUrl(String username)
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://widgets.pinterest.com/v3/pidgets/users/");
        stringBuilder.append(username);
        stringBuilder.append("/pins/");
        return stringBuilder.toString();
    }
}
