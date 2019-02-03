package io.keyu.urekalite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class SignupPasswordFragment : Fragment() {

    private lateinit var passwordNextBtn: MaterialButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater.inflate(R.layout.view_signup_password, container, false)
        passwordNextBtn = rootView.findViewById(R.id.passwordNextBtn)
//        passwordNextBtn.setOnClickListener {
//            val fragmentManager = activity!!.supportFragmentManager
//            val fragmentTransaction = fragmentManager
//                .beginTransaction()
//                .replace(R.id.signupContentContainer, fragment)
//                .addToBackStack(null)
//                .commit()
//        }
        return rootView
    }
}