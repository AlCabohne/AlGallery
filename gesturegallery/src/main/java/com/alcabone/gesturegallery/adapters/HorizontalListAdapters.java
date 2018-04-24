package com.alcabone.gesturegallery.adapters;

import android.app.Activity;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alcabone.gesturegallery.OnImgClick;
import com.alcabone.gesturegallery.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static android.support.v7.widget.RecyclerView.NO_POSITION;

public class HorizontalListAdapters extends RecyclerView.Adapter<HorizontalListAdapters.HorizontalImageViewHolder>
{
    private ArrayList<String> images;
    private Activity activity;
    private int selectedItem = -1;
    private OnImgClick imgClick;

    public HorizontalListAdapters(Activity activity, ArrayList<String> images, OnImgClick imgClick) {
        this.activity = activity;
        this.images = images;
        this.imgClick = imgClick;
    }

    @NonNull
    @Override
    public HorizontalImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new HorizontalImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal_image, null));
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalImageViewHolder holder, final int position)
    {
        Glide.with(activity).load(images.get(position)).into(holder.image);
        ColorMatrix matrix = new ColorMatrix();

        if (selectedItem != position) {
            matrix.setSaturation(0);
            ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
            holder.image.setColorFilter(filter);
            holder.image.setAlpha(0.7f);
        } else {
            matrix.setSaturation(1);
            ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
            holder.image.setColorFilter(filter);
            holder.image.setAlpha(1f);
        }
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public void setSelectedItem(int position) {
        selectedItem = position;
        notifyDataSetChanged();
    }

    public class HorizontalImageViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView image;

        HorizontalImageViewHolder(View itemView)
        {
            super(itemView);
            image = itemView.findViewById(R.id.iv);
            image.setOnClickListener((view) -> {
                if (imgClick != null && getAdapterPosition() != NO_POSITION)
                    imgClick.onClick(getAdapterPosition());
            });
        }
    }
}
