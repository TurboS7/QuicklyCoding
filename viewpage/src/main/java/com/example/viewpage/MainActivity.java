package com.example.viewpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private List<View> viewList = new ArrayList<View>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        viewPager = findViewById(R.id.viewPager);

        LayoutInflater from = getLayoutInflater().from(this);
        View view1 = from.inflate(R.layout.layout_value1,null);
        View view2 = from.inflate(R.layout.layout_value2,null);
        View view3 = from.inflate(R.layout.layout_value3,null);
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
//        viewPager.setPageMargin(1000);
       viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
           @Override
           public void transformPage(@NonNull View page, float position) {
               System.out.println("transformPage: page = "+page+"position "+position);
           }
       });
        viewPager.setAdapter(new MAdapter(viewList));
    }
}