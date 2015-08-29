package com.jwang.android.pinterestdemo.model;

/**
 * Created by jiajunwang on 8/28/15.
 */
public class ModelPin extends ModelBase
{
    private String mDescription;
    private ModelUser mModelUser;
    private String mRepinCount;
    private String mDominantColor;
    private String mLikeCount;
    private String mLink;
    private String mImageUrl;
    private String mId;

    public String getDescription()
    {
        return mDescription;
    }

    public void setDescription(String mDescription)
    {
        this.mDescription = mDescription;
    }

    public ModelUser getModelUser()
    {
        return mModelUser;
    }

    public void setModelUser(ModelUser mModelUser)
    {
        this.mModelUser = mModelUser;
    }

    public String getLikeCount()
    {
        return mLikeCount;
    }

    public void setLikeCount(String mLikeCount)
    {
        this.mLikeCount = mLikeCount;
    }

    public String getDominantColor()
    {
        return mDominantColor;
    }

    public void setDominantColor(String mDominantColor)
    {
        this.mDominantColor = mDominantColor;
    }

    public String getRepinCount()
    {
        return mRepinCount;
    }

    public void setRepinCount(String mRepinCount)
    {
        this.mRepinCount = mRepinCount;
    }

    public String getLink()
    {
        return mLink;
    }

    public void setLink(String mLink)
    {
        this.mLink = mLink;
    }

    public String getImageUrl()
    {
        return mImageUrl;
    }

    public void setImageUrl(String mImageUrl)
    {
        this.mImageUrl = mImageUrl;
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
