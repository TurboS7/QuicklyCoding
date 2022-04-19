package com.example.mrecycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Bean> beanList = new ArrayList<Bean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*初始化数据*/
        recyclerView = findViewById(R.id.mRecyclerView);
        for (int i = 0; i < 10000; i++) {
            beanList.add(new Bean("鲁班"+i+"号"));
        }
        MAdapter mAdapter = new MAdapter(this,beanList);
        /*设置布局方式*/
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,LinearLayout.VERTICAL));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this,3,RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnRecyclerClickerListener(new MAdapter.OnRecyclerClickListener() {
            @Override
            public void OnRecyclerItemClick(int postion) {
                Toast.makeText(getApplication(), beanList.get(postion).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}