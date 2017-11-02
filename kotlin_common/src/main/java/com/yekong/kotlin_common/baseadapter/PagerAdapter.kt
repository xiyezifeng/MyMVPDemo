package com.yekong.kotlin_common.baseadapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by xigua on 2017/10/19.
 */
class PagerAdapter(fm: FragmentManager?,list: List<Fragment>) : FragmentPagerAdapter(fm) {
    var list = list
    override fun getItem(position: Int): Fragment {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        list.get(position)
    }

    override fun getCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        list.size
    }
}