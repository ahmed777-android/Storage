package com.example.storage.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.storage.R;

public class ViewHold extends RecyclerView.ViewHolder implements View.OnClickListener  {
    OnItemClick onItemClick;
    TextView textView;
    ImageView imageView;
    public ViewHold(@NonNull View itemView , OnItemClick onClick) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);
        imageView= itemView.findViewById(R.id.image);
        itemView.setOnClickListener(this);
        onItemClick= onClick;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        onItemClick.onItemClick(getAdapterPosition());
    }
}
