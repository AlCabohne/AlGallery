package com.alcabone.gesturegallery;

import android.app.Activity;
import android.content.Intent;

import com.alcabone.gesturegallery.activities.GridActivity;
import com.alcabone.gesturegallery.entities.ZColor;

import java.util.ArrayList;

/**
 * Created by mohamedzakaria on 8/7/16.
 */
public class GridBuilder
{
    private Activity mActivity;
    private ArrayList<String> imagesURLs;
    private String title;
    private int spanCount = 2;
    private int toolbarColor = -1;
    private int imgPlaceHolderResId = -1;
    private ZColor color;

    private GridBuilder() {
    }

    /**
     * @param activity   Refrence from current activity
     * @param imagesURLs Image URLs to be displayed
     */
    public static GridBuilder with(Activity activity, ArrayList<String> imagesURLs) {
        return new GridBuilder(activity, imagesURLs);
    }


    private GridBuilder(Activity activity, ArrayList<String> imagesURLs) {
        this.imagesURLs = imagesURLs;
        this.mActivity = activity;
    }

    /**
     * Set toolbar title
     *
     * @param title
     * @return
     */
    public GridBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Set grid layout colums count (default: 2)
     *
     * @param count integer number for colum count
     * @return
     */
    public GridBuilder setSpanCount(int count) {
        this.spanCount = count;
        return this;
    }

    /**
     * Setting toolbar Color ResourceId
     *
     * @param colorResId
     * @return
     */
    public GridBuilder setToolbarColorResId(int colorResId) {
        this.toolbarColor = colorResId;
        return this;
    }

    /**
     * Set placeholder image for images in the grid
     * @param imgPlaceHolderResId
     * @return
     */
    public GridBuilder setGridImgPlaceHolder(int imgPlaceHolderResId) {
        this.imgPlaceHolderResId = imgPlaceHolderResId;
        return this;
    }

    /**
     * Setting toolbar color
     *
     * @param color enum color may be black or white
     * @return
     */
    public GridBuilder setToolbarTitleColor(ZColor color) {
        this.color = color;
        return this;
    }
    /**
     * Start the grid activity with builder settings
     */
    public void show() {
        Intent gridActivity = new Intent(mActivity, GridActivity.class);
        gridActivity.putExtra(GalleryConstants.IntentPassingParams.IMAGES, imagesURLs);
        gridActivity.putExtra(GalleryConstants.IntentPassingParams.COUNT, spanCount);
        gridActivity.putExtra(GalleryConstants.IntentPassingParams.TITLE, title);
        gridActivity.putExtra(GalleryConstants.IntentPassingParams.TOOLBAR_COLOR_ID, toolbarColor);
        gridActivity.putExtra(GalleryConstants.IntentPassingParams.IMG_PLACEHOLDER, imgPlaceHolderResId);
        gridActivity.putExtra(GalleryConstants.IntentPassingParams.TOOLBAR_TITLE_COLOR, color);
        mActivity.startActivity(gridActivity);
    }
}
