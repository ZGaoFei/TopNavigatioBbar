package com.example.zgfei.topnavigationbar;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用 TabLayout 实现顶部状态栏滑动的效果
 *
 * 1、将 TabLayout 和 ViewPager 独立开来需要设置
 * tabLayout.setupWithViewPager(viewPager);
 *
 * 2、将 TabLayout 放在 ViewPager 里面可以不用设置
 */
public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private List<InnerFragment> list;
    private String[] titles;
    private InnerFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initView() {
        tabLayout = (TabLayout) findViewById(R.id.tab_layout_main);
        viewPager = (ViewPager) findViewById(R.id.vp_main);

        viewPager.setAdapter(adapter);

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);// 可滑动的展示
        //tabLayout.setTabMode(TabLayout.MODE_FIXED);// 固定展示
        for (String title : titles) {
            tabLayout.addTab(tabLayout.newTab().setText(title));
        }

//        tabLayout.setupWithViewPager(viewPager);
    }

    private void initData() {
        list = new ArrayList<>();
        titles = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven"};

        InnerFragment oneFragment = InnerFragment.newInstance("one fragment");
        InnerFragment twoFragment = InnerFragment.newInstance("two fragment");
        InnerFragment threeFragment = InnerFragment.newInstance("three fragment");
        InnerFragment fourFragment = InnerFragment.newInstance("four fragment");
        InnerFragment fiveFragment = InnerFragment.newInstance("five fragment");
        InnerFragment sixFragment = InnerFragment.newInstance("six fragment");
        InnerFragment sevenFragment = InnerFragment.newInstance("seven fragment");
        InnerFragment eightFragment = InnerFragment.newInstance("eight fragment");
        InnerFragment nineFragment = InnerFragment.newInstance("nine fragment");
        InnerFragment tenFragment = InnerFragment.newInstance("ten fragment");
        InnerFragment elevenFragment = InnerFragment.newInstance("eleven fragment");

        list.add(oneFragment);
        list.add(twoFragment);
        list.add(threeFragment);
        list.add(fourFragment);
        list.add(fiveFragment);
        list.add(sixFragment);
        list.add(sevenFragment);
        list.add(eightFragment);
        list.add(nineFragment);
        list.add(tenFragment);
        list.add(elevenFragment);

        adapter = new InnerFragmentAdapter(getSupportFragmentManager(), list, titles);
    }
}
