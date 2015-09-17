package com.jwang.android.pinterestdemo.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jwang.android.pinterestdemo.R;
import com.jwang.android.pinterestdemo.model.ModelPin;
import com.squareup.picasso.Picasso;

/**
 * Created by jiajunwang on 8/28/15.
 */
public class WeatherAdapter extends
        RecyclerView.Adapter<WeatherAdapter.ViewHolder>
{
    private ArrayList<String> mTemps = new ArrayList<>();

    public WeatherAdapter()
    {
    }

    public void setModelPins(ArrayList<String> temps)
    {
        mTemps = temps;
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
        String temString = mTemps.get(position);
        if (!TextUtils.isEmpty(temString))
        {
            viewHolder.mTemTextView.setText(temString);
        }
    }

    @Override
    public int getItemCount()
    {
        return mTemps.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener
    {
        public final TextView mTemTextView;

        public ViewHolder(View view)
        {
            super(view);
            mTemTextView = (TextView) view.findViewById(R.id.tv_tem);
        }

        @Override
        public void onClick(View view)
        {
        }
    }
}
