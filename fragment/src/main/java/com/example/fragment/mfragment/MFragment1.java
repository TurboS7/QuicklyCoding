package com.example.fragment.mfragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragment.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MFragment1 extends Fragment {

    private View root;
    private TextView tv_fm1;
    private Button btn_fm1;
    static int flag = 0;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        System.out.println("onAttach" + (flag += 1));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("onCreate" + (flag += 1));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("onCreateView" + (flag += 1));
        if (root == null) {
            root = inflater.inflate(R.layout.fragment_simple1, container, false);
        }
        tv_fm1 = (TextView) root.findViewById(R.id.tv_fm1);
        btn_fm1 = (Button) root.findViewById(R.id.btn_fm1);
        btn_fm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
                tv_fm1.setText(date);
                Toast.makeText(getContext(), date, Toast.LENGTH_SHORT).show();
            }
        });
        return root;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("onActivityCreated" + (flag += 1));
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("onStart" + (flag += 1));
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("onResume" + (flag += 1));
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("onPause" + (flag += 1));
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("onStop" + (flag += 1));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("onDestroyView" + (flag += 1));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy" + (flag += 1));
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("onDetach" + (flag += 1));
    }
}