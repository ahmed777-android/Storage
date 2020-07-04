package com.example.storage.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.storage.model.DataItem;

public class ListItemCallback  extends DiffUtil.ItemCallback<DataItem> {

    @Override
    public boolean areItemsTheSame(@NonNull DataItem oldItem, @NonNull DataItem newItem) {
        return  oldItem.getItemId().equals(newItem.getItemId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull DataItem oldItem, @NonNull DataItem newItem) {
        return  oldItem.getItemName().equals(newItem.getItemName());
    }
}
