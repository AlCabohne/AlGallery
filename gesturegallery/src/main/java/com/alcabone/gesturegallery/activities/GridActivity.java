package com.alcabone.gesturegallery.activities;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.alcabone.gesturegallery.GalleryBuilder;
import com.alcabone.gesturegallery.GalleryConstants;
import com.alcabone.gesturegallery.R;
import com.alcabone.gesturegallery.adapters.GridImagesAdapter;
import com.alcabone.gesturegallery.listeners.GridClickListener;

public final class GridActivity extends BaseActivity implements GridClickListener {

    @Override
    protected int getResourceLayoutId() {
        return R.layout.activity_grid;
    }

    @Override
    protected void afterInflation() {
        // init layout
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);

        // get extra values
        int imgPlaceHolderResId = getIntent().getIntExtra(GalleryConstants.IntentPassingParams.IMG_PLACEHOLDER, -1);
        int spanCount = getIntent().getIntExtra(GalleryConstants.IntentPassingParams.COUNT, 2);

        //init adapter
        GridImagesAdapter adapter = new GridImagesAdapter(this, imageURLs, imgPlaceHolderResId);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, spanCount));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(int pos) {
        GalleryBuilder.withUrls(this, imageURLs)
                .setToolbarTitleColor(toolbarTitleColor)
                .setFullscreenMode(onlyFullscreen)
                .setShowBackButton(showBackButton)
                .setSelectedImgPosition(pos)
                .setTitle(mToolbar.getTitle().toString())
                .show();
    }
}
