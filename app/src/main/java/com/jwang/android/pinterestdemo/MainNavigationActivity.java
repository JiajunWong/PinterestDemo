package com.jwang.android.pinterestdemo;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.jwang.android.pinterestdemo.activity.BaseActivity;
import com.jwang.android.pinterestdemo.adapter.WeatherAdapter;
import com.jwang.android.pinterestdemo.interfaces.OnRequestWeatherResultListener;
import com.jwang.android.pinterestdemo.task.FetchWeatherTask;

public class MainNavigationActivity extends BaseActivity
{
    private static final String SELECTED_KEY = "selected_position";
    private static final String USERNAME_KEY = "username";
    private int mPosition = ListView.INVALID_POSITION;

    private RecyclerView mRecyclerView;
    private WeatherAdapter mWeatherAdapter;
    private FetchWeatherTask mRequestUserPinTask;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWeatherAdapter = new WeatherAdapter();
        mRecyclerView = (RecyclerView) findViewById(R.id.lv_medias);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(getResources().getInteger(R.integer.column_count), StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mWeatherAdapter);

        mRequestUserPinTask = new FetchWeatherTask(this);
        mRequestUserPinTask.setOnRequestPinResultListener(mOnRequestWeatherResultListener);
        mRequestUserPinTask.execute();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        // If there's instance state, mine it for useful information.
        // The end-goal here is that the user never knows that turning their device sideways
        // does crazy lifecycle related things.  It should feel like some stuff stretched out,
        // or magically appeared to take advantage of room, but data or place in the app was never
        // actually *lost*.
        if (savedInstanceState != null)
        {
            if (savedInstanceState.containsKey(SELECTED_KEY))
            {
                // The listview probably hasn't even been populated yet.  Actually perform the
                // swapout in onLoadFinished.
                mPosition = savedInstanceState.getInt(SELECTED_KEY);
            }
        }
    }

    private OnRequestWeatherResultListener mOnRequestWeatherResultListener = new OnRequestWeatherResultListener()
    {
        @Override
        public void onResult(ArrayList<String> arrayList)
        {
            mWeatherAdapter.setModelPins(arrayList);
            mWeatherAdapter.notifyDataSetChanged();
            if (mPosition != ListView.INVALID_POSITION)
            {
                mRecyclerView.scrollToPosition(mPosition);
            }
        }
    };

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        // When tablets rotate, the currently selected list item needs to be saved.
        // When no item is selected, mPosition will be set to Listview.INVALID_POSITION,
        // so check for that before storing.
        if (mPosition != ListView.INVALID_POSITION)
        {
            outState.putInt(SELECTED_KEY, mPosition);
        }

        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
