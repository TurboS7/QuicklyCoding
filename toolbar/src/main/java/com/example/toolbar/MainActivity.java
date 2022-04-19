package com.example.toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar, toolbar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*布局文件设置*/
        toolbar = findViewById(R.id.bar_m);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(), "点击返回键", Toast.LENGTH_SHORT).show();
            }
        });
        /*java代码设置*/
        toolbar1 = findViewById(R.id.bar_m1);
        toolbar1.setTitle("代码标题");
        toolbar1.setLogo(R.drawable.imag_msg);
        toolbar1.setTitleMarginStart(90);
        toolbar1.setSubtitle("subtitle");
        toolbar1.setNavigationIcon(R.drawable.abc_vector_test);
        toolbar1.setBackgroundColor(Color.parseColor("#ffaaaa"));
        toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(), "代码设置", Toast.LENGTH_SHORT).show();
            }
        });
    }
}