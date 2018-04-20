package com.alcabone.gesturegallery;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class ImageViewHolder extends RecyclerView.ViewHolder {
    public ImageView image;

    public ImageViewHolder(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.imageView);
    }
}
