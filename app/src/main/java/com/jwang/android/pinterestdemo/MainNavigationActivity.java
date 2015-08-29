package com.jwang.android.pinterestdemo;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.jwang.android.pinterestdemo.activity.BaseActivity;
import com.jwang.android.pinterestdemo.adapter.PinAdapter;
import com.jwang.android.pinterestdemo.interfaces.OnRequestPinResultListener;
import com.jwang.android.pinterestdemo.model.ModelPin;
import com.jwang.android.pinterestdemo.task.RequestUserPinTask;

public class MainNavigationActivity extends BaseActivity
{
    private static final String SELECTED_KEY = "selected_position";
    private int mPosition = ListView.INVALID_POSITION;

    private RecyclerView mRecyclerView;
    private PinAdapter mPinAdapter;
    private RequestUserPinTask mRequestUserPinTask;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPinAdapter = new PinAdapter(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.lv_medias);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(getResources().getInteger(R.integer.column_count), StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mPinAdapter);

        // If there's instance state, mine it for useful information.
        // The end-goal here is that the user never knows that turning their device sideways
        // does crazy lifecycle related things.  It should feel like some stuff stretched out,
        // or magically appeared to take advantage of room, but data or place in the app was never
        // actually *lost*.
        if (savedInstanceState != null && savedInstanceState.containsKey(SELECTED_KEY))
        {
            // The listview probably hasn't even been populated yet.  Actually perform the
            // swapout in onLoadFinished.
            mPosition = savedInstanceState.getInt(SELECTED_KEY);
        }

        setupToolBar();
    }

    private void setupToolBar()
    {
        mToolbar.findViewById(R.id.search_pin).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String username = ((EditText) mToolbar.findViewById(R.id.et_username)).getText().toString();
                requestUserPin(username);
            }
        });
    }

    private OnRequestPinResultListener mOnRequestPinResultListener = new OnRequestPinResultListener()
    {
        @Override
        public void onResult(ArrayList<ModelPin> arrayList)
        {
            mPinAdapter.setModelPins(arrayList);
            mPinAdapter.notifyDataSetChanged();
            if (mPosition != ListView.INVALID_POSITION)
            {
                mRecyclerView.scrollToPosition(mPosition);
            }
        }
    };

    private void requestUserPin(String username)
    {
        mRequestUserPinTask = new RequestUserPinTask(this);
        mRequestUserPinTask.setOnRequestPinResultListener(mOnRequestPinResultListener);
        mRequestUserPinTask.execute(username);
    }

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
