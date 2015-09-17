package com.jwang.android.pinterestdemo.util;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.text.TextUtils;

/**
 * Created by jiajunwang on 8/28/15.
 */
public class HttpRequestResultUtil
{
    public static ArrayList<String> parseWeatherJsonObject(String jsonString)
    {
        ArrayList<String> result = new ArrayList<>();
        JSONObject respondJsonObject;
        try
        {
            respondJsonObject = new JSONObject(jsonString);
            if (respondJsonObject.has("list"))
            {
                JSONArray tempsJsonArray = respondJsonObject.getJSONArray("list");
                if (tempsJsonArray != null && tempsJsonArray.length() > 0)
                {
                    for (int i = 0; i < tempsJsonArray.length(); i++)
                    {
                        JSONObject temJsonObject = tempsJsonArray.getJSONObject(i);
                        if (temJsonObject.has("main"))
                        {
                            JSONObject mainJsonObject = temJsonObject.getJSONObject("main");
                            if (mainJsonObject.has("temp"))
                            {
                                String tem = mainJsonObject.getString("temp");
                                if (!TextUtils.isEmpty(tem))
                                {
                                    result.add(tem);
                                }
                            }
                        }
                    }
                }
            }
        }
        catch (Exception e)
        {
        }

        return result;
    }
}
