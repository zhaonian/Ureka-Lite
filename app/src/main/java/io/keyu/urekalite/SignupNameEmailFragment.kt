package io.keyu.urekalite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class SignupNameEmailFragment : Fragment() {

    private lateinit var nameEmailNextBtn: MaterialButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater.inflate(R.layout.view_signup_name_email, container, false)
        nameEmailNextBtn = rootView.findViewById(R.id.nameEmailNextBtn)
        nameEmailNextBtn.setOnClickListener {
            val fragmentManager = activity!!.supportFragmentManager
            fragmentManager
                .beginTransaction()
                .setCustomAnimations(
                    R.anim.slide_in_right, R.anim.slide_out_left,
                    R.anim.slide_in_left, R.anim.slide_out_right
                )
                .replace(R.id.signupContentContainer, SignupPasswordFragment())
                .addToBackStack(null)
                .commit()
        }
        return rootView
    }
}