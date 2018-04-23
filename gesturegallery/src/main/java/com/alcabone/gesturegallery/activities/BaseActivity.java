package com.alcabone.gesturegallery.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.alcabone.gesturegallery.GalleryConstants;
import com.alcabone.gesturegallery.R;

import java.util.ArrayList;

public abstract class BaseActivity extends AppCompatActivity
{
    protected Toolbar mToolbar;
    protected ArrayList<String> imageURLs;
    protected int toolbarTitleColor;
    protected boolean onlyFullscreen;
    private int showBackButton;
    private String title;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResourceLayoutId());

        // get values
        getValues();
        // configure Toolbar
        applyToolbar();

        afterInflation();
    }

    private void getValues(){
        imageURLs = getIntent().getStringArrayListExtra(GalleryConstants.IntentPassingParams.IMAGES);
        title = getIntent().getStringExtra(GalleryConstants.IntentPassingParams.TITLE);
        toolbarTitleColor = getIntent().getIntExtra(GalleryConstants.IntentPassingParams.TOOLBAR_TITLE_COLOR, -1);
        onlyFullscreen = getIntent().getBooleanExtra(GalleryConstants.IntentPassingParams.ONLYFULLSCREEN, false);
        showBackButton = getIntent().getIntExtra(GalleryConstants.IntentPassingParams.SHOWBACKBUTTON, 0);
    }

    private void applyToolbar()
    {
        mToolbar = findViewById(R.id.toolbar);

        if (getSupportActionBar() == null) {
            setSupportActionBar(mToolbar);
            mToolbar.setVisibility(View.VISIBLE);
            if (title != null && getSupportActionBar() != null) {
                getSupportActionBar().setTitle(title);
            }
            if (toolbarTitleColor != -1)
                mToolbar.setTitleTextColor(ContextCompat.getColor(this, toolbarTitleColor));
            if (showBackButton == GalleryConstants.ColorOptions.BACK_BUTTON_WHITE)
                mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white);
            else if (showBackButton == GalleryConstants.ColorOptions.BACK_BUTTON_BLACK)
                mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black);

//            mToolbar.setVisibility(View.VISIBLE);
//            if (toolbarTitleColor == ZColor.BLACK) {
//                mToolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.black));
//                getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black);
//            } else {
//                mToolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white));
//                getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white);
//            }
//            mToolbar.setBackgroundColor(getResources().getColor(toolbarColorResId));
//            if (title != null) {
//                getSupportActionBar().setTitle(title);
//            }
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setHomeButtonEnabled(true);
        } else {
            mToolbar.setVisibility(View.GONE);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }


    protected abstract int getResourceLayoutId();

    protected abstract void afterInflation();
}
