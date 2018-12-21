package com.alcabone.gesturegallery.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.alcabone.gesturegallery.R;
import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapter extends PagerAdapter {

    private LayoutInflater mLayoutInflater;
    private ArrayList<String> images;
    private boolean isShowing = true;
    private Toolbar toolbar;
    private RecyclerView imagesHorizontalList;
    private boolean onlyFullscreen;

    public ViewPagerAdapter(Context context, ArrayList<String> images, Toolbar toolbar, RecyclerView imagesHorizontalList, boolean onlyFullscreen)
    {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.images = images;
        this.toolbar = toolbar;
        this.imagesHorizontalList = imagesHorizontalList;
        this.onlyFullscreen = onlyFullscreen;
        if (onlyFullscreen) makeFullscreen();
    }

    private void makeFullscreen()
    {
        toolbar.setVisibility(View.GONE);
        imagesHorizontalList.setVisibility(View.GONE);
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
        View itemView = mLayoutInflater.inflate(R.layout.item_pager, container, false);
        PhotoView photoView = itemView.findViewById(R.id.iv);
        photoView.setMaximumScale(10);

        Glide.with(container.getContext()).load(images.get(position))
                .into(photoView);

        if (!onlyFullscreen) photoView.setOnPhotoTapListener(new AlOnPhotoTapListener());

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
                    toolbar.animate().translationY(-toolbar.getBottom()).setInterpolator(new AccelerateInterpolator()).start();
                    imagesHorizontalList.animate().translationY(imagesHorizontalList.getBottom()).setInterpolator(new AccelerateInterpolator()).start();
                } else {
                    isShowing = true;
                    toolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator()).start();
                    imagesHorizontalList.animate().translationY(0).setInterpolator(new DecelerateInterpolator()).start();
                }
            }
        }
    }
}
