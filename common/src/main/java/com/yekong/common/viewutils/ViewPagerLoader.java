package com.yekong.common.viewutils;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.yekong.common.baseadapter.FragmentViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xigua on 2017/11/1.
 */

public class ViewPagerLoader {
    public static void loadFragmentToPager(List<Fragment> list, ViewPager viewPager ,FragmentManager fm){
        FragmentViewPagerAdapter adapter = new FragmentViewPagerAdapter(fm,(ArrayList<Fragment>) list);
        viewPager.setOffscreenPageLimit(list.size());
        viewPager.setAdapter(adapter);
    }
}
