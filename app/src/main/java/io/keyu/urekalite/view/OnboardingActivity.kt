package io.keyu.urekalite.view

import android.os.Bundle
import io.keyu.urekalite.R
import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.fragment.app.FragmentActivity
import com.google.android.material.button.MaterialButton
import com.ogaclejapan.smarttablayout.SmartTabLayout
import io.keyu.urekalite.service.SharedPreferenceService
import androidx.core.content.ContextCompat
import android.animation.ArgbEvaluator

class OnboardingActivity : FragmentActivity() {

    private lateinit var pager: ViewPager
    private lateinit var indicator: SmartTabLayout
    private lateinit var skip: MaterialButton
    private lateinit var next: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        pager = findViewById(R.id.pager)
        indicator = findViewById(R.id.indicator)
        skip = findViewById(R.id.skip)
        next = findViewById(R.id.next)

        val adapter = object : FragmentStatePagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return when (position) {
                    0 -> OnboardingFragment1()
                    1 -> OnboardingFragment2()
                    2 -> OnboardingFragment3()
                    else -> OnboardingFragment1()
                }
            }

            override fun getCount(): Int {
                return 3
            }
        }
        pager.adapter = adapter

        val color1 = ContextCompat.getColor(this, R.color.orange_light)
        val color2 = ContextCompat.getColor(this, R.color.green_light)
        val color3 = ContextCompat.getColor(this, R.color.purple_light)
        val colorList = intArrayOf(color1, color2, color3)
        val evaluator = ArgbEvaluator()

        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                val colorUpdate = evaluator.evaluate(
                    positionOffset,
                    colorList[position],
                    colorList[if (position == 2) position else position + 1]
                ) as Int
                pager.setBackgroundColor(colorUpdate)
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> pager.setBackgroundColor(color1)
                    1 -> pager.setBackgroundColor(color2)
                    2 -> pager.setBackgroundColor(color3)
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        indicator.setViewPager(pager)
        indicator.setOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {

            override fun onPageSelected(position: Int) {
                if (position == 2) {
                    skip.visibility = View.GONE
                    next.text = "Ureka!"
                } else {
                    skip.visibility = View.VISIBLE
                    next.text = "Next"
                }
            }
        })

        skip.setOnClickListener { finishOnboarding() }

        next.setOnClickListener {
            if (pager.currentItem == 2) {
                finishOnboarding()
            } else {
                pager.setCurrentItem(pager.currentItem + 1, true)
            }
        }
    }

    private fun finishOnboarding() {
        SharedPreferenceService.setOnboardingStatus(this, true)
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
