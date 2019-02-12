package io.keyu.urekalite.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import io.keyu.urekalite.R

class SignupEmailConfirmationFragment : Fragment() {

    private lateinit var doneBtn: MaterialButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.view_signup_email_confirmation, container, false)
        doneBtn = rootView.findViewById(R.id.doneBtn)
        doneBtn.setOnClickListener {
            startActivity(Intent(activity, HomeActivity::class.java))
            activity?.finish()
        }
        return rootView
    }
}