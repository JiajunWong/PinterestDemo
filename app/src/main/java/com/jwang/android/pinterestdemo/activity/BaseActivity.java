package com.jwang.android.pinterestdemo.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;

import com.jwang.android.pinterestdemo.R;

/**
 * Created by jiajunwang on 8/28/15.
 */
public class BaseActivity extends AppCompatActivity
{
    protected Toolbar mToolbar;
    protected ActionBar mActionBar;

    @Override
    public void setContentView(int layoutResID)
    {
        super.setContentView(layoutResID);
        setupActionBar();
    }

    protected void setupActionBar()
    {
        // Use Toolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null)
        {
            setSupportActionBar(mToolbar);

            mActionBar = getSupportActionBar();
            mActionBar.setHomeButtonEnabled(true);
            mActionBar.setDisplayShowTitleEnabled(false);

            try
            {
                final String label = getString(getPackageManager().getActivityInfo(getComponentName(), 0).labelRes);
                if (!TextUtils.isEmpty(label))
                {
                    setTitle(label);
                }
            }
            catch (final Exception e)
            {
            }
        }
        else
        {
            mActionBar = getSupportActionBar();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return false;
    }

    protected void setDisplayHomeAsUpEnabled(boolean enabled)
    {
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(enabled);
        }
    }
}
