package com.alcabone.gesturegallery;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.alcabone.gesturegallery.activities.GalleryActivity;
import com.alcabone.gesturegallery.entities.ZColor;

import java.util.ArrayList;

public class GalleryBuilder
{
    private Activity mActivity;
    private ArrayList<String> imagesURLs;
    private String title;
    private int spanCount = 2;
    private int toolbarColor = -1;
    private int imgPlaceHolderResId = -1;
    private ZColor color;
    private int selectedImgPosition;
    private ZColor backgroundColor;

    private GalleryBuilder() {
    }

    /**
     * @param activity   Refrence from current activity
     * @param imagesURLs Image URLs to be displayed
     */
    public static GalleryBuilder withUrls(Activity activity, ArrayList<String> imagesURLs) {
        return new GalleryBuilder(activity, imagesURLs, null);
    }

    public static GalleryBuilder withIds(Activity activity, ArrayList<Integer> imagesIds) {
        return new GalleryBuilder(activity, null, imagesIds);
    }

    private GalleryBuilder(Activity activity, @Nullable ArrayList<String> imagesURLs, @Nullable ArrayList<Integer> resIds) {
        if (imagesURLs == null && resIds != null) imagesURLs = resolveImages(activity, resIds);
        this.imagesURLs = imagesURLs;
        this.mActivity = activity;
    }

    /**
     * Set z_toolbar title
     *
     * @param title
     * @return
     */
    public GalleryBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Setting z_toolbar Color ResourceId
     *
     * @param colorResId
     * @return
     */
    public GalleryBuilder setToolbarColorResId(int colorResId) {
        this.toolbarColor = colorResId;
        return this;
    }

    /**
     * Setting z_toolbar color
     *
     * @param color enum color may be black or white
     * @return
     */
    public GalleryBuilder setToolbarTitleColor(ZColor color) {
        this.color = color;
        return this;
    }

    /**
     * Setting starting position
     *
     * @param selectedImgPosition
     * @return
     */
    public GalleryBuilder setSelectedImgPosition(int selectedImgPosition) {
        this.selectedImgPosition = selectedImgPosition;
        return this;
    }

    public GalleryBuilder setGalleryBackgroundColor(ZColor backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * Start the gallery activity with builder settings
     */
    public void show() {
        Intent gridActivity = new Intent(mActivity, GalleryActivity.class);
        gridActivity.putExtra(Constants.IntentPassingParams.IMAGES, imagesURLs);
        gridActivity.putExtra(Constants.IntentPassingParams.TITLE, title);
        gridActivity.putExtra(Constants.IntentPassingParams.TOOLBAR_COLOR_ID, toolbarColor);
        gridActivity.putExtra(Constants.IntentPassingParams.TOOLBAR_TITLE_COLOR, color);
        gridActivity.putExtra(Constants.IntentPassingParams.SELECTED_IMG_POS, selectedImgPosition);
        gridActivity.putExtra(Constants.IntentPassingParams.BG_COLOR, backgroundColor);
        mActivity.startActivity(gridActivity);
    }

    private String getPathFromResId(int resId, Context context){
        Resources resources = context.getResources();
        Uri uri = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(resources.getResourcePackageName(resId))
                .appendPath(resources.getResourceTypeName(resId))
                .appendPath(resources.getResourceEntryName(resId))
                .build();

        return uri.toString();
    }

    private ArrayList<String> resolveImages(Context context, ArrayList<Integer> resIds)
    {
        ArrayList<String> images = new ArrayList<>();
        for (int id : resIds)
        {
            images.add(getPathFromResId(id, context));
        }
        return images;
    }
}
