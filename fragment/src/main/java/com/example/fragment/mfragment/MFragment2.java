package com.example.fragment.mfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.fragment.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MFragment2 extends Fragment {

    private View root;
    private TextView tv_fm1;
    private Button btn_fm1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (root == null){
            root = inflater.inflate(R.layout.fragment_simple2, container, false);
        }
         tv_fm1 = (TextView)root.findViewById(R.id.tv_fm2);
        btn_fm1 = (Button) root.findViewById(R.id.btn_fm2);
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
}