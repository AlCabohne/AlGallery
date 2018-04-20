package com.alcabone.gesturegallery.activities;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.alcabone.gesturegallery.Constants;
import com.alcabone.gesturegallery.CustomViewPager;
import com.alcabone.gesturegallery.OnImgClick;
import com.alcabone.gesturegallery.R;
import com.alcabone.gesturegallery.adapters.HorizontalListAdapters;
import com.alcabone.gesturegallery.adapters.ViewPagerAdapter;
import com.alcabone.gesturegallery.entities.ZColor;

public class GalleryActivity extends BaseActivity {

    CustomViewPager mViewPager;
    ViewPagerAdapter adapter;
    RecyclerView imagesHorizontalList;
    LinearLayoutManager mLayoutManager;
    HorizontalListAdapters hAdapter;

    @Override
    protected int getResourceLayoutId() {
        return R.layout.z_activity_gallery;
    }

    @Override
    protected void afterInflation() {
        // init layouts
        RelativeLayout mainLayout = findViewById(R.id.mainLayout);
        mViewPager = findViewById(R.id.pager);
        imagesHorizontalList = findViewById(R.id.imagesHorizontalList);

        // get intent data
        int currentPos = getIntent().getIntExtra(Constants.IntentPassingParams.SELECTED_IMG_POS, 0);
//        ZColor bgColor = (ZColor) getIntent().getSerializableExtra(Constants.IntentPassingParams.BG_COLOR);
//
//        if (bgColor == ZColor.WHITE) {
//            mainLayout.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
//        }

        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        // pager adapter
        adapter = new ViewPagerAdapter(this, imageURLs, mToolbar, imagesHorizontalList);
        mViewPager.setAdapter(adapter);
        // horizontal list adapter
        hAdapter = new HorizontalListAdapters(this, imageURLs, new OnImgClick() {
            @Override
            public void onClick(int pos) {
                mViewPager.setCurrentItem(pos, true);
            }
        });
        imagesHorizontalList.setLayoutManager(mLayoutManager);
        imagesHorizontalList.setAdapter(hAdapter);
        hAdapter.notifyDataSetChanged();

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

        hAdapter.setSelectedItem(currentPos);
        mViewPager.setCurrentItem(currentPos);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
