package com.example.popupwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onShowWindows(View view) {
        View inflate = getLayoutInflater().inflate(R.layout.layout_window, null);
        Button btn1 = inflate.findViewById(R.id.btn_sure);
        Button btn2 = inflate.findViewById(R.id.btn_cancel);

        PopupWindow window = new PopupWindow(inflate, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
//        window.setFocusable(true);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(), "sure", Toast.LENGTH_SHORT).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(), "cancel", Toast.LENGTH_SHORT).show();
                window.dismiss();
            }
        });
        window.showAsDropDown(view);

    }
}