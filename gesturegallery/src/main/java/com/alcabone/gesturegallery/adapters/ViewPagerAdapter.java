package com.alcabone.gesturegallery.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.alcabone.gesturegallery.R;
import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.PhotoView;
import com.github.chrisbanes.photoview.PhotoViewAttacher;

import java.util.ArrayList;

public class ViewPagerAdapter extends PagerAdapter {

    private LayoutInflater mLayoutInflater;
    private ArrayList<String> images;
    private boolean isShowing = true;
    private Toolbar toolbar;
    private RecyclerView imagesHorizontalList;

    public ViewPagerAdapter(Context context, ArrayList<String> images, Toolbar toolbar, RecyclerView imagesHorizontalList) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.images = images;
        this.toolbar = toolbar;
        this.imagesHorizontalList = imagesHorizontalList;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.z_pager_item, container, false);
        PhotoView photoView = itemView.findViewById(R.id.iv);
        photoView.setMaximumScale(10);

        Glide.with(container.getContext()).load(images.get(position))
                .into(photoView);

        photoView.setOnPhotoTapListener(new AlOnPhotoTapListener());

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    public class AlOnPhotoTapListener implements OnPhotoTapListener{

        @Override
        public void onPhotoTap(ImageView view, float x, float y)
        {
            {
                if (isShowing) {
                    isShowing = false;
//                toolbar.setVisibility(View.GONE);
                    toolbar.animate().translationY(-toolbar.getBottom()).setInterpolator(new AccelerateInterpolator()).start();
//                relativeLayout.animate().translationY(-toolbar.getBottom()).setInterpolator(new AccelerateInterpolator()).start();
                    imagesHorizontalList.animate().translationY(imagesHorizontalList.getBottom()).setInterpolator(new AccelerateInterpolator()).start();
                } else {
                    isShowing = true;
//                toolbar.setVisibility(View.VISIBLE);
                    toolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator()).start();
//                relativeLayout.animate().translationY(0).setInterpolator(new DecelerateInterpolator()).start();
                    imagesHorizontalList.animate().translationY(0).setInterpolator(new DecelerateInterpolator()).start();
                }
            }
        }
    }
}
