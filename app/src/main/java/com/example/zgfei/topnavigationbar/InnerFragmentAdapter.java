package com.example.zgfei.topnavigationbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by zgfei on 2017/5/5.
 *
 * 使用 FragmentStatePagerAdapter 时
 * 系统只会创建当前页面和初始化其相邻的页面
 * 当超过相邻页面时，系统会自动销毁与当前页面不相邻的页面
 */

public class InnerFragmentAdapter extends FragmentStatePagerAdapter {
    private List<InnerFragment> list;
    private String[] titles;

    public InnerFragmentAdapter(FragmentManager fm, List<InnerFragment> list, String[] titles) {
        super(fm);
        this.list = list;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
