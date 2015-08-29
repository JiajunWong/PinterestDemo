package com.jwang.android.pinterestdemo.util;

import android.util.Log;

import com.jwang.android.pinterestdemo.model.ModelPin;
import com.jwang.android.pinterestdemo.model.ModelUser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by jiajunwang on 8/28/15.
 */
public class HttpRequestResultUtil
{
    public static ArrayList<ModelPin> parsePinJsonObject(String jsonString)
    {
        ArrayList<ModelPin> result = new ArrayList<>();
        JSONObject respondJsonObject;
        try
        {
            respondJsonObject = new JSONObject(jsonString);
            if (respondJsonObject.has("data"))
            {
                JSONObject dataJsonObject = respondJsonObject.getJSONObject("data");
                if (dataJsonObject.has("pins"))
                {
                    JSONArray pinArray = dataJsonObject.getJSONArray("pins");
                    if (pinArray != null && pinArray.length() > 0)
                    {
                        for (int i = 0; i < pinArray.length(); i++)
                        {
                            JSONObject pinJsonObject = pinArray.getJSONObject(i);
                            ModelPin modelPin = new ModelPin();
                            if (pinJsonObject.has("description"))
                            {
                                modelPin.setDescription(pinJsonObject.getString("description"));
                            }

                            if (pinJsonObject.has("pinner"))
                            {
                                JSONObject pinnerJsonObject = pinJsonObject.getJSONObject("pinner");
                                ModelUser modelUser = new ModelUser();
                                if (pinnerJsonObject != null)
                                {
                                    if (pinnerJsonObject.has("about"))
                                    {
                                        modelUser.setAbout(pinnerJsonObject.getString("about"));
                                    }
                                    if (pinnerJsonObject.has("location"))
                                    {
                                        modelUser.setLocation(pinnerJsonObject.getString("location"));
                                    }
                                    if (pinnerJsonObject.has("full_name"))
                                    {
                                        modelUser.setFullName(pinnerJsonObject.getString("full_name"));
                                    }
                                    if (pinnerJsonObject.has("follower_count"))
                                    {
                                        modelUser.setFollowerCount(pinnerJsonObject.getString("follower_count"));
                                    }
                                    if (pinnerJsonObject.has("image_small_url"))
                                    {
                                        modelUser.setImageSmallUrl(pinnerJsonObject.getString("image_small_url"));
                                    }
                                    if (pinnerJsonObject.has("pin_count"))
                                    {
                                        modelUser.setPinCount(pinnerJsonObject.getString("pin_count"));
                                    }
                                    if (pinnerJsonObject.has("id"))
                                    {
                                        modelUser.setId(pinnerJsonObject.getString("id"));
                                    }
                                    if (pinnerJsonObject.has("profile_url"))
                                    {
                                        modelUser.setProfileUrl(pinnerJsonObject.getString("profile_url"));
                                    }
                                }
                                modelPin.setModelUser(modelUser);
                            }

                            if (pinJsonObject.has("repin_count"))
                            {
                                modelPin.setRepinCount(pinJsonObject.getString("repin_count"));
                            }

                            if (pinJsonObject.has("dominant_color"))
                            {
                                modelPin.setDominantColor(pinJsonObject.getString("dominant_color"));
                            }

                            if (pinJsonObject.has("link"))
                            {
                                modelPin.setLink(pinJsonObject.getString("link"));
                            }

                            if (pinJsonObject.has("images"))
                            {
                                JSONObject imageJsonObject = pinJsonObject.getJSONObject("images");
                                if (imageJsonObject != null && imageJsonObject.has("237x"))
                                {
                                    JSONObject jsonObject = imageJsonObject.getJSONObject("237x");
                                    if (jsonObject != null && jsonObject.has("url"))
                                    {
                                        modelPin.setImageUrl(jsonObject.getString("url"));
                                    }
                                }
                            }

                            if (pinJsonObject.has("id"))
                            {
                                modelPin.setId(pinJsonObject.getString("id"));
                            }

                            result.add(modelPin);
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
