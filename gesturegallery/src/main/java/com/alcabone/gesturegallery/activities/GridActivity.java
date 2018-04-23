package com.alcabone.gesturegallery.activities;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.alcabone.gesturegallery.GalleryBuilder;
import com.alcabone.gesturegallery.GalleryConstants;
import com.alcabone.gesturegallery.R;
import com.alcabone.gesturegallery.adapters.GridImagesAdapter;
import com.alcabone.gesturegallery.adapters.listeners.GridClickListener;

/**
 * Created by mohamedzakaria on 8/6/16.
 */
public final class GridActivity extends BaseActivity implements GridClickListener {
    private RecyclerView mRecyclerView;
    private GridImagesAdapter adapter;

    private int imgPlaceHolderResId;
    private int spanCount = 2;

    @Override
    protected int getResourceLayoutId() {
        return R.layout.z_activity_grid;
    }

    @Override
    protected void afterInflation() {
        mRecyclerView = findViewById(R.id.recyclerView);

        // get extra values
        imgPlaceHolderResId = getIntent().getIntExtra(GalleryConstants.IntentPassingParams.IMG_PLACEHOLDER, -1);
        spanCount = getIntent().getIntExtra(GalleryConstants.IntentPassingParams.COUNT, 2);

        adapter = new GridImagesAdapter(this, imageURLs, imgPlaceHolderResId);
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
//                .setToolbarTitleColor(R.color.)
//                .setToolbarColorResId(toolbarColorResId)
                .setSelectedImgPosition(pos)
                .setTitle(mToolbar.getTitle().toString())
                .show();
    }
}
