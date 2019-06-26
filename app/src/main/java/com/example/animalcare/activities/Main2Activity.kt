package com.example.animalcare.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.example.animalcare.R
import com.example.animalcare.fragments_slide.*

class Main2Activity : AppCompatActivity() {

    var pagerAdapter: SlideAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_slide)
        pagerAdapter = SlideAdapter(supportFragmentManager)
        pagerAdapter!!.addFragments(Fragment1())
        pagerAdapter!!.addFragments(Fragment2())
        pagerAdapter!!.addFragments(Fragment3())
        pagerAdapter!!.addFragments(Fragment4())
        pagerAdapter!!.addFragments(Fragment5())
        pagerAdapter!!.addFragments(Fragment6())
        pagerAdapter!!.addFragments(FragmentInicio())

        val pager = findViewById<View>(R.id.vp_main) as ViewPager

        pager.adapter = pagerAdapter
    }
}