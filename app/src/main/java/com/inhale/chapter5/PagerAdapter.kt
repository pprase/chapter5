package com.inhale.chapter5

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import java.util.ArrayList

class PagerAdapter(fragment: FragmentManager): FragmentStatePagerAdapter(fragment)
{
    var fragmentList = ArrayList<Fragment>()
    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }
    fun addFragment (fragment: Fragment){
        fragmentList.add(fragment)
    }
}