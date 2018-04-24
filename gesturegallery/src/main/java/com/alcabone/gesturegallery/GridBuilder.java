package com.alcabone.gesturegallery;

import android.app.Activity;
import android.content.Intent;

import com.alcabone.gesturegallery.activities.GridActivity;
import com.alcabone.gesturegallery.util.PathResolver;

import java.util.ArrayList;

public class GridBuilder
{
    private Activity mActivity;
    private ArrayList<String> imagesURLs;
    private String title;
    private int spanCount = 2;
    private int imgPlaceHolderResId = -1;
    private int titleColorID = -1;
    private int showBackButton = 0;

    /**
     * @param activity   Reference from current activity
     * @param imagesURLs Image URLs to be displayed
     */
    public static GridBuilder withURL(Activity activity, ArrayList<String> imagesURLs)
    {
        return new GridBuilder(activity, imagesURLs);
    }

    /**
     * @param activity    Reference from current activity
     * @param resourceIds Ressource Ids to be displayed
     */
    public static GridBuilder withIds(Activity activity, ArrayList<Integer> resourceIds)
    {
        ArrayList<String> imageURLs = PathResolver.resolveImages(activity, resourceIds);
        return new GridBuilder(activity, imageURLs);
    }

    public static GridBuilder withIds(Activity activity, int[] resourceIds)
    {
        ArrayList<String> imageURLs = PathResolver.resolveImages(activity, resourceIds);
        return new GridBuilder(activity, imageURLs);
    }

    private GridBuilder(Activity activity, ArrayList<String> imagesURLs) {
        this.imagesURLs = imagesURLs;
        this.mActivity = activity;
    }

    /**
     * Set Toolbar title
     *
     * @param title The title to be displayed
     * @return GridBuilder Instance
     */
    public GridBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Set grid layout columns count (default: 2)
     *
     * @param count integer number for colum count
     * @return GridBuilder Instance
     */
    public GridBuilder setSpanCount(int count) {
        this.spanCount = count;
        return this;
    }

    /**
     * Set placeholder image for images in the grid
     * @param imgPlaceHolderResId Resource ID for Placeholder
     * @return GridBuilder Instance
     */
    public GridBuilder setGridImgPlaceHolder(int imgPlaceHolderResId) {
        this.imgPlaceHolderResId = imgPlaceHolderResId;
        return this;
    }

    /**
     * Setting Show Back Button
     *
     * @param showBackButton choose one of GalleryConstants.ColorOptions.BACK_BUTTON_WHITE, GalleryConstants.ColorOptions.BACK_BUTTON_BLACK
     *                       GalleryConstants.ColorOptions.BACK_BUTTON_NONE,
     * @return GridBuilder Instance
     */
    public GridBuilder setShowBackButton(int showBackButton)
    {
        this.showBackButton = showBackButton;
        return this;
    }

    /**
     * Setting Toolbar Title color
     *
     * @param titleColorID a color ID for the Title.
     * @return GridBuilder Instance
     */
    public GridBuilder setToolbarTitleColor(int titleColorID)
    {
        this.titleColorID = titleColorID;
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
        gridActivity.putExtra(GalleryConstants.IntentPassingParams.IMG_PLACEHOLDER, imgPlaceHolderResId);
        gridActivity.putExtra(GalleryConstants.IntentPassingParams.TOOLBAR_TITLE_COLOR, titleColorID);
        gridActivity.putExtra(GalleryConstants.IntentPassingParams.SHOWBACKBUTTON, showBackButton);
        mActivity.startActivity(gridActivity);
    }
}
