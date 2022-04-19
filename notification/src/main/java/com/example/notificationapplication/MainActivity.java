package com.example.notificationapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private NotificationManager manager;
    private Notification notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    private void init() {
        /*创建NotificationManager*/
        System.out.println("init");
        /*实例化NotificationManager*/
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        /*当前的系统版本大于28时*/
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("zs1", "通知", NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(notificationChannel);
        }
        /*用于跳转到其他的页面*/
        Intent intent = new Intent(this, NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        notification = new NotificationCompat.Builder(this, "zs1")
                .setSmallIcon(R.drawable.imag_msg) /*设置小图标*/
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.img))
                .setContentTitle("app通知")   /*设置标题*/
                .setContentText("这是一条消息！") /*设置文本内容*/
                .setColor(Color.parseColor("#e24128"))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setWhen(System.currentTimeMillis()) /*设置当前时间*/
                .build();
    }

    public void OnSend(View view) {
        /*发送notifaction*/
        manager.notify(2, notification);
    }

    public void OnCancel(View view) {
        /*取消notification*/
        manager.cancel(2);
    }
}