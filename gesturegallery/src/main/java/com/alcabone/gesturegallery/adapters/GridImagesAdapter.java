package com.alcabone.gesturegallery.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alcabone.gesturegallery.R;
import com.alcabone.gesturegallery.listeners.GridClickListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static androidx.recyclerview.widget.RecyclerView.NO_POSITION;

public class GridImagesAdapter extends RecyclerView.Adapter<GridImagesAdapter.ImageViewHolder>
{
    private ArrayList<String> imageURLs;
    private Activity mActivity;
    private int imgPlaceHolderResId = -1;
    private GridClickListener clickListener;

    public GridImagesAdapter(Activity activity, ArrayList<String> imageURLs, int imgPlaceHolderResId) {
        this.imageURLs = imageURLs;
        this.mActivity = activity;
        this.imgPlaceHolderResId = imgPlaceHolderResId;
        this.clickListener = (GridClickListener) activity;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new ImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_image, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, final int position)
    {
        Glide.with(mActivity).load(imageURLs.get(position))
                .apply(new RequestOptions().placeholder(imgPlaceHolderResId != -1 ? imgPlaceHolderResId : R.drawable.placeholder))
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return imageURLs != null ? imageURLs.size() : 0;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView image;

        ImageViewHolder(View itemView)
        {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            image.setOnClickListener((view) -> {
                if (clickListener != null && getAdapterPosition() != NO_POSITION)
                    clickListener.onClick(getAdapterPosition());
            });
        }
    }
}
