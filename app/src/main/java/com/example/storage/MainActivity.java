package com.example.storage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import com.example.storage.adapter.Adapt;
import com.example.storage.adapter.OnItemClick;
import com.example.storage.model.DataItem;
import com.example.storage.sample.SampleDataProvider;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClick {
    List<DataItem> dataItemList = SampleDataProvider.dataItemList;
    private RecyclerView mRecyclerView;
    private Adapt mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rv);
        //   Collections.sort(dataItemList, new Comparator<DataItem>() {
        //       @Override
        ///         public int compare(DataItem o1, DataItem o2) {
        ///           return o1.getItemName().compareTo(o2.getItemName());
        //       }
        //   });
        setRecyclerView();
    }

    private void setRecyclerView() {
        mAdapter = new Adapt(this, this);
        RecyclerView.LayoutManager mLayoutManager = null;
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mAdapter.submitList(dataItemList);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("m", dataItemList.get(position));
        startActivity(intent);

    }
}