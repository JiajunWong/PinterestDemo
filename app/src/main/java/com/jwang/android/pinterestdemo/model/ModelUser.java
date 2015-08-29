package com.jwang.android.pinterestdemo.model;

/**
 * Created by jiajunwang on 8/28/15.
 */
public class ModelUser extends ModelBase
{
    private String mAbout;
    private String mLocation;
    private String mFullName;
    private String mFollowerCount;
    private String mImageSmallUrl;
    private String mPinCount;
    private String mId;
    private String mProfileUrl;

    public String getAbout()
    {
        return mAbout;
    }

    public void setAbout(String mAbout)
    {
        this.mAbout = mAbout;
    }

    public String getLocation()
    {
        return mLocation;
    }

    public void setLocation(String mLocation)
    {
        this.mLocation = mLocation;
    }

    public String getFullName()
    {
        return mFullName;
    }

    public void setFullName(String mFullName)
    {
        this.mFullName = mFullName;
    }

    public String getFollowerCount()
    {
        return mFollowerCount;
    }

    public void setFollowerCount(String mFollowerCount)
    {
        this.mFollowerCount = mFollowerCount;
    }

    public String getImageSmallUrl()
    {
        return mImageSmallUrl;
    }

    public void setImageSmallUrl(String mImageSmallUrl)
    {
        this.mImageSmallUrl = mImageSmallUrl;
    }

    public String getPinCount()
    {
        return mPinCount;
    }

    public void setPinCount(String mPinCount)
    {
        this.mPinCount = mPinCount;
    }

    public String getProfileUrl()
    {
        return mProfileUrl;
    }

    public void setProfileUrl(String mProfileUrl)
    {
        this.mProfileUrl = mProfileUrl;
    }

    public String getId()
    {
        return mId;
    }

    public void setId(String mId)
    {
        this.mId = mId;
    }
}
