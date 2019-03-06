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

class OnboardingActivity : FragmentActivity() {

    private var pager: ViewPager? = null
    private var indicator: SmartTabLayout? = null
    private var skip: MaterialButton? = null
    private var next: MaterialButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_onboarding)

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

        pager!!.adapter = adapter

        indicator!!.setViewPager(pager)

        indicator!!.setOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {

            override fun onPageSelected(position: Int) {
                if (position == 2) {
                    skip!!.visibility = View.GONE
                    next!!.text = "Done"
                } else {
                    skip!!.visibility = View.VISIBLE
                    next!!.text = "Next"
                }
            }
        })

        skip!!.setOnClickListener(View.OnClickListener { finishOnboarding() })

        next!!.setOnClickListener(View.OnClickListener {
            if (pager!!.currentItem == 2) {
                finishOnboarding()
            } else {
                pager!!.setCurrentItem(pager!!.currentItem + 1, true)
            }
        })
    }

    private fun finishOnboarding() {
        SharedPreferenceService.setOnboardingStatus(this, true)
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
