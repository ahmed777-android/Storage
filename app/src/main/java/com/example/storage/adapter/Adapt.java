package com.example.storage.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;

import androidx.annotation.NonNull;

import com.example.storage.R;
import com.example.storage.model.DataItem;

import java.io.IOException;
import java.io.InputStream;

public class Adapt extends ListAdapter<DataItem,ViewHold> {

    private static final ListItemCallback ListItemCallback = new ListItemCallback();
    Context mContext;
    OnItemClick onItemClick;
    public Adapt(Context context, OnItemClick onItemClick) {
        super(ListItemCallback);
        this.mContext = context;
        this.onItemClick = onItemClick;
    }
    @NonNull
    @Override
    public ViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_view, parent, false);
        return new ViewHold(view, onItemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHold holder, int position) {
        DataItem item = getItem(position);
        holder.textView.setText(item.getItemName());
        InputStream inputStream =null ;
        try {
            String imageFile = item.getImage();
            inputStream = mContext.getAssets().open(imageFile);
            Drawable drawable =Drawable.createFromStream(inputStream,null);
            holder.imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            {
                try {
                    if (inputStream != null){
                        inputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
