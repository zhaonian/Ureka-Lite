package io.keyu.urekalite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_signup.toolbar

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_material)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.signupContentContainer, SignupNameEmailFragment())
            .addToBackStack(null)
            .commit()
    }
}