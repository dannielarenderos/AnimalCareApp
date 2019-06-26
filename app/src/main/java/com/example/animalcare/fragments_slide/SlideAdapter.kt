package com.example.animalcare.fragments_slide

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class SlideAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    var mFragmentItems: ArrayList<Fragment> = ArrayList()

    fun addFragments(fragmentItem: Fragment) {
        mFragmentItems.add(fragmentItem)
    }

    override fun getItem(position: Int): Fragment {
        return mFragmentItems[position]
    }

    override fun getCount(): Int {
        return mFragmentItems.size
    }
}