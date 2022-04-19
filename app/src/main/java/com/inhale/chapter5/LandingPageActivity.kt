package com.inhale.chapter5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.inhale.chapter5.databinding.ActivityLandingPageBinding

class LandingPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLandingPageBinding
    private val pagerAdapter by lazy {
        PagerAdapter (supportFragmentManager)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.run {
            viewPager.offscreenPageLimit=3
            pagerAdapter.addFragment(FragmentLanding1())
            pagerAdapter.addFragment(FragmentLanding2())
            pagerAdapter.addFragment(FragmentLanding3())
            viewPager.adapter = pagerAdapter
            dotsIndicator.setViewPager(viewPager)
        }
    }

}