package com.example.fragmentmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fragmentmanager.mfragment.ItemFragment;
import com.example.fragmentmanager.mfragment.MEmptyFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * FmagmentManager的demo
 * 动态添加fragment
 * 步骤：
 * step1：创建一个待处理的fragment
 * step2：通过getSupportFragmentManager 获取一个FragmentManager对象来管理Fragment
 * step3：开启事务 beginTransaction()
 * step4：使用transaction替换fragment
 * step5：提交事务
 */
public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MEmptyFragment mEmptyFragment = new MEmptyFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelable("map", new Bean("小鸟"));
                mEmptyFragment.setArguments(bundle);
                mEmptyFragment.setFragmentCallBack(new MFragmentCallBack() {
                    @Override
                    public void sendMsgToActivity(String msg) {
                        Toast.makeText(MainActivity.this,msg, Toast.LENGTH_SHORT).show();

                    }
                    @Override
                    public String getMsgFromActivity() {
                        return "来自Activity的消息：date："+ new SimpleDateFormat("yyyy-MM-DD HH:mm:ss").format(new Date(System.currentTimeMillis()));
                    }
                });
                updateView(mEmptyFragment);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateView(new ItemFragment());
            }
        });

    }

    private void updateView(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl, fragment);
        transaction.addToBackStack("demo");/*将fragment添加到栈中，以实现返回到上一个fragment的效果*/
        transaction.commit();
    }


}