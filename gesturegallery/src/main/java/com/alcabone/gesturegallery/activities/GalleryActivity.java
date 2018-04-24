package com.alcabone.gesturegallery.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.alcabone.gesturegallery.CustomViewPager;
import com.alcabone.gesturegallery.GalleryConstants;
import com.alcabone.gesturegallery.R;
import com.alcabone.gesturegallery.adapters.HorizontalListAdapters;
import com.alcabone.gesturegallery.adapters.ViewPagerAdapter;

public class GalleryActivity extends BaseActivity {

    CustomViewPager mViewPager;
    ViewPagerAdapter adapter;
    RecyclerView imagesHorizontalList;
    LinearLayoutManager mLayoutManager;
    HorizontalListAdapters hAdapter;

    @Override
    protected int getResourceLayoutId() {
        return R.layout.activity_gallery;
    }

    @Override
    protected void afterInflation() {
        // init layouts
        initLayout();

        // get intent data after configuration change
        int currentPos = getIntent().getIntExtra(GalleryConstants.IntentPassingParams.SELECTED_IMG_POS, 0);

        // setAdapters
        setAdapters();

        hAdapter.setSelectedItem(currentPos);
        mViewPager.setCurrentItem(currentPos);
    }

    private void initLayout()
    {
        mViewPager = findViewById(R.id.pager);
        imagesHorizontalList = findViewById(R.id.imagesHorizontalList);
    }

    private void setAdapters()
    {
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        // pager adapter
        adapter = new ViewPagerAdapter(this, imageURLs, mToolbar, imagesHorizontalList, onlyFullscreen);
        mViewPager.setAdapter(adapter);
        // horizontal list adapter
        hAdapter = new HorizontalListAdapters(this, imageURLs, pos -> mViewPager.setCurrentItem(pos, true));
        imagesHorizontalList.setLayoutManager(mLayoutManager);
        imagesHorizontalList.setAdapter(hAdapter);
//        hAdapter.notifyDataSetChanged();

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                imagesHorizontalList.smoothScrollToPosition(position);
                hAdapter.setSelectedItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
