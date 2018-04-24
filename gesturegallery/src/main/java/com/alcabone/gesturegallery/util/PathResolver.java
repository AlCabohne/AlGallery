package com.alcabone.gesturegallery.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;

import java.util.ArrayList;

public class PathResolver
{
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

    public static ArrayList<String> resolveImages(Context context, ArrayList<Integer> resIds)
    {
        ArrayList<String> images = new ArrayList<>();
        for (int id : resIds)
        {
            images.add(getPathFromResId(id, context));
        }
        return images;
    }

    public static ArrayList<String> resolveImages(Context context, int[] resIds)
    {
        ArrayList<String> images = new ArrayList<>();
        for (int id : resIds)
        {
            images.add(getPathFromResId(id, context));
        }
        return images;
    }
}
