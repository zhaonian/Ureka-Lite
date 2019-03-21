package io.keyu.urekalite.view

import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import io.keyu.urekalite.R

class OnboardingFragment1 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_onboarding1, container, false)
    }
}
