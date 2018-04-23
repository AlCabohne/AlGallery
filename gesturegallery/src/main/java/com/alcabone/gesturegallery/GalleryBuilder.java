package com.alcabone.gesturegallery;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.alcabone.gesturegallery.activities.GalleryActivity;

import java.util.ArrayList;

public class GalleryBuilder
{
    private Activity mActivity;
    private ArrayList<String> imagesURLs;
    private String title;
    //    private int spanCount = 2;
//    private int toolbarColor = -1;
//    private int imgPlaceHolderResId = -1;
    private int titleColorID = -1;
    private int selectedImgPosition;
    private boolean onlyFullscreen;
    private int showBackButton = 0;

    private GalleryBuilder(Activity activity, ArrayList<String> imagesURLs)
    {
        this.imagesURLs = imagesURLs;
        this.mActivity = activity;
    }

    /**
     * @param activity   Reference from current activity
     * @param imagesURLs Image URLs to be displayed
     */
    public static GalleryBuilder withUrls(Activity activity, ArrayList<String> imagesURLs) {
        return new GalleryBuilder(activity, imagesURLs);
    }

    /**
     * @param activity    Reference from current activity
     * @param resourceIds Ressource Ids to be displayed
     */
    public static GalleryBuilder withIds(Activity activity, ArrayList<Integer> resourceIds)
    {
        ArrayList<String> imageURLs = resolveImages(activity, resourceIds);
        return new GalleryBuilder(activity, imageURLs);
    }

    private GalleryBuilder(Activity activity, @Nullable ArrayList<String> imagesURLs, @Nullable ArrayList<Integer> resIds) {
        if (imagesURLs == null && resIds != null) imagesURLs = resolveImages(activity, resIds);
        this.imagesURLs = imagesURLs;
        this.mActivity = activity;
    }

    public static GalleryBuilder withIds(Activity activity, int[] resourceIds)
    {
        ArrayList<String> imageURLs = resolveImages(activity, resourceIds);
        return new GalleryBuilder(activity, imageURLs);
    }

    private static String getPathFromResId(int resId, Context context)
    {
        Resources resources = context.getResources();
        Uri uri = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(resources.getResourcePackageName(resId))
                .appendPath(resources.getResourceTypeName(resId))
                .appendPath(resources.getResourceEntryName(resId))
                .build();

        return uri.toString();
    }

    private static ArrayList<String> resolveImages(Context context, ArrayList<Integer> resIds)
    {
        ArrayList<String> images = new ArrayList<>();
        for (int id : resIds)
        {
            images.add(getPathFromResId(id, context));
        }
        return images;
    }

    private static ArrayList<String> resolveImages(Context context, int[] resIds)
    {
        ArrayList<String> images = new ArrayList<>();
        for (int id : resIds)
        {
            images.add(getPathFromResId(id, context));
        }
        return images;
    }

    /**
     * Set Toolbar title
     *
     * @param title The title to be displayed
     * @return GalleryBuilder Instance
     */
    public GalleryBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Set Fullscreen Mode
     *
     * @param fullscreen If true, no Toolbar and Image Bar is shown
     * @return GalleryBuilder Instance
     */

    public GalleryBuilder setFullscreenMode(boolean fullscreen)
    {
        this.onlyFullscreen = fullscreen;
        return this;
    }

    /**
     * Setting Toolbar Title color
     *
     * @param titleColorID enum color may be black or white
     * @return GalleryBuilder Instance
     */
    public GalleryBuilder setToolbarTitleColor(int titleColorID)
    {
        this.titleColorID = titleColorID;
        return this;
    }

    /**
     * Setting Show Back Button
     *
     * @param showBackButton choose one of GalleryConstants.ColorOptions.BACK_BUTTON_WHITE, GalleryConstants.ColorOptions.BACK_BUTTON_BLACK
     *                       GalleryConstants.ColorOptions.BACK_BUTTON_NONE,
     * @return GalleryBuilder Instance
     */
    public GalleryBuilder setShowBackButton(int showBackButton)
    {
        this.showBackButton = showBackButton;
        return this;
    }

    /**
     * Setting starting position
     *
     * @param selectedImgPosition List position of starting Picture
     * @return GalleryBuilder Instance
     */
    public GalleryBuilder setSelectedImgPosition(int selectedImgPosition) {
        this.selectedImgPosition = selectedImgPosition;
        return this;
    }

    /**
     * Start the gallery activity with builder settings
     */
    public void show() {
        Intent gridActivity = new Intent(mActivity, GalleryActivity.class);
        gridActivity.putExtra(GalleryConstants.IntentPassingParams.IMAGES, imagesURLs);
        gridActivity.putExtra(GalleryConstants.IntentPassingParams.TITLE, title);
        gridActivity.putExtra(GalleryConstants.IntentPassingParams.ONLYFULLSCREEN, onlyFullscreen);
        gridActivity.putExtra(GalleryConstants.IntentPassingParams.SHOWBACKBUTTON, showBackButton);
        gridActivity.putExtra(GalleryConstants.IntentPassingParams.TOOLBAR_TITLE_COLOR, titleColorID);
        gridActivity.putExtra(GalleryConstants.IntentPassingParams.SELECTED_IMG_POS, selectedImgPosition);
        mActivity.startActivity(gridActivity);
    }
}
