package io.keyu.urekalite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.signupContentContainer, SignupNameEmailFragment())
            .commit()
    }
}