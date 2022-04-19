package com.example.androidapp;


import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private ProgressBar progressBarH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        progressBar = findViewById(R.id.m_pb);
        progressBarH = findViewById(R.id.m_pb_h);
    }

    public void onClickAlertDialog(View view) {
        View alertView = getLayoutInflater().inflate(R.layout.alert_view, null);
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_launcher_foreground)
                .setTitle("AlertDailog")
                .setMessage("This is AlertDailog!")
                .setView(alertView)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplication(), "sure", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplication(), "cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("alertDialog", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplication(), "alertDialog", Toast.LENGTH_SHORT).show();
                    }
                })
                .create()
                .show();
    }

    public void onClickProgressbar(View view) {
        if (progressBar.getVisibility() == View.GONE) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    public void onClickProgressbarH(View view) {
        int value = progressBarH.getProgress();
        value += 25;
        if (value > 100) {
            value = 0;
        }
        progressBarH.setProgress(value);
    }
}