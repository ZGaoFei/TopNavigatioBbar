package com.example.zgfei.topnavigationbar;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 添加标签
 * isVisible：当前 fragment 是否显示
 * isPrepared：当前 fragment 是否初始化布局
 *
 * 以此来实现懒加载
 * 即：当前页面显示的时候才会进行需要的操作
 */
public class InnerFragment extends Fragment {
    private TextView textView;

    private String name;
    private boolean isVisible = false;
    private boolean isPrepared = false;

    public static InnerFragment newInstance(String fragmentName) {
        InnerFragment fragment = new InnerFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", fragmentName);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        name = bundle.getString("name");

        Log.e("=====onCreate=====", "=========" + name);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inter, container, false);
        isPrepared = true;
        Log.e("===onCreateView====", "=======" + name);
        initView(view);

        loadData();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("=onDestroy=", "=========" + name);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e("======", name + " is " + isVisibleToUser);
        isVisible = isVisibleToUser;

        if (isVisibleToUser) {
            loadData();
        }
    }

    private void initView(View view) {
        textView = (TextView) view.findViewById(R.id.tv_inner_fragment);

        textView.setText(name);
    }

    private void loadData() {
        if (!isPrepared || !isVisible) {
            return;
        }
        Log.e("===loadData==", name + "=====" + isPrepared + "====" + isVisible);
        //在这里进行实现懒加载
    }

}
