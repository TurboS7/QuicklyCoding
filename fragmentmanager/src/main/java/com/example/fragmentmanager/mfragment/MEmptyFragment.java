package com.example.fragmentmanager.mfragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragmentmanager.Bean;
import com.example.fragmentmanager.MFragmentCallBack;
import com.example.fragmentmanager.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MEmptyFragment extends Fragment {

    private View root;
    private MFragmentCallBack fragmentCallBack;
    static int flag = 0;

    public void setFragmentCallBack(MFragmentCallBack callBack) {
        fragmentCallBack = callBack;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("onAttach" + (flag += 1));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("onAttach" + (flag += 1));
        // Inflate the layout for this fragment
        if (root == null) {
            root = inflater.inflate(R.layout.fragment_m_empty, container, false);
        }
        updateUI();

        return root;
    }

    private void updateUI() {
        /*获取activity中传过来的值*/
        Bundle bundle = this.getArguments();
        Bean bean = bundle.getParcelable("map");
        TextView textView = root.findViewById(R.id.tv_empty1);
        Button btn_send = root.findViewById(R.id.btn_send_msg);
        Button btn_get = root.findViewById(R.id.btn_get_msg);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss").format(new Date(System.currentTimeMillis()));
                fragmentCallBack.sendMsgToActivity("来自fragment的消息：date：" + date);
            }
        });
        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MEmptyFragment.this.getContext(), fragmentCallBack.getMsgFromActivity(), Toast.LENGTH_SHORT).show();
            }
        });
        textView.setText(bean.toString());
    }

    /*生命周期的其他阶段*/

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        System.out.println("onAttach" + (flag += 1));
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
        flag = 0;
    }
}