package io.keyu.urekalite.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import io.keyu.urekalite.R

class SignupPasswordFragment : Fragment() {

    private lateinit var passwordNextBtn: MaterialButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater.inflate(R.layout.view_signup_password, container, false)
        passwordNextBtn = rootView.findViewById(R.id.passwordNextBtn)
        passwordNextBtn.setOnClickListener {
            activity!!.supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(
                    R.anim.slide_in_right, R.anim.slide_out_left,
                    R.anim.slide_in_left, R.anim.slide_out_right
                )
                .replace(R.id.signupContentContainer, SignupRoleFragment())
                .addToBackStack(null)
                .commit()
        }
        return rootView
    }
}