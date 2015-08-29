package com.jwang.android.pinterestdemo.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jwang.android.pinterestdemo.R;
import com.jwang.android.pinterestdemo.model.ModelPin;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

/**
 * Created by jiajunwang on 8/28/15.
 */
public class PinAdapter extends RecyclerView.Adapter<PinAdapter.ViewHolder>
{
    private Context mContext;
    private ArrayList<ModelPin> mModelPins = new ArrayList<>();

    public PinAdapter(Context context)
    {
        mContext = context;
    }

    public void setModelPins(ArrayList<ModelPin> pins)
    {
        mModelPins = pins;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        if (viewGroup instanceof RecyclerView)
        {
            int layoutId = R.layout.list_item_media;
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(layoutId, viewGroup, false);
            view.setFocusable(true);
            return new ViewHolder(view);
        }
        else
        {
            throw new RuntimeException("Not bound to RecyclerView");
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position)
    {
        ModelPin modelPin = mModelPins.get(position);
        if (!TextUtils.isEmpty(modelPin.getModelUser().getImageSmallUrl()))
        {
            Picasso.with(mContext).load(modelPin.getModelUser().getImageSmallUrl()).into(viewHolder.mOwnerProfileImage);
        }

        if (!TextUtils.isEmpty(modelPin.getModelUser().getFullName()))
        {
            viewHolder.mOwnerUserName.setText(modelPin.getModelUser().getFullName());
        }

        if (!TextUtils.isEmpty(modelPin.getDescription()))
        {
            viewHolder.mCaptionText.setVisibility(View.VISIBLE);
            viewHolder.mCaptionText.setText(modelPin.getDescription());
        }
        else
        {
            viewHolder.mCaptionText.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(modelPin.getImageUrl()))
        {
            Picasso.with(mContext).load(modelPin.getImageUrl()).into(viewHolder.mMediaImage);
        }
    }

    @Override
    public int getItemCount()
    {
        return mModelPins.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener
    {
        public final RoundedImageView mOwnerProfileImage;
        public final TextView mOwnerUserName;
        public final TextView mCaptionText;
        public final ImageView mMediaImage;
        public final View mUserInfoRootView;

        public ViewHolder(View view)
        {
            super(view);
            mOwnerProfileImage = (RoundedImageView) view.findViewById(R.id.owner_profile_image);
            mOwnerUserName = (TextView) view.findViewById(R.id.owner_username);
            mMediaImage = (ImageView) view.findViewById(R.id.media_image);
            mCaptionText = (TextView) view.findViewById(R.id.caption_text);
            mUserInfoRootView = view.findViewById(R.id.root_user_info);

            mUserInfoRootView.setOnClickListener(this);
            mMediaImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View view)
        {
            //            int adapterPosition = getAdapterPosition();
            //            mCursor.moveToPosition(adapterPosition);
            //            int indexOwnerId = mCursor.getColumnIndex(MediaContract.MediaEntry.COLUMN_MEDIA_OWNER_ID);
            //            String ownerId = mCursor.getString(indexOwnerId);
            //            int indexMediaId = mCursor.getColumnIndex(MediaContract.MediaEntry.COLUMN_MEDIA_INSTAGRAM_ID);
            //            String mediaId = mCursor.getString(indexMediaId);
            //
            //            switch (view.getId())
            //            {
            //                case R.id.root_user_info:
            //                    if (!TextUtils.isEmpty(ownerId))
            //                    {
            //                        UserDetailActivity.startActivity(mContext, mOwnerProfileImage, ownerId);
            //                    }
            //                    else
            //                    {
            //                        Log.e(TAG, "Owner Id is Null!!");
            //                    }
            //                    break;
            //                case R.id.media_image:
            //                    if (!TextUtils.isEmpty(mediaId))
            //                    {
            //                        MediaDetailActivity.startActivity(mContext, mMediaImage, mediaId);
            //                    }
            //                    break;
            //            }
        }
    }
}
