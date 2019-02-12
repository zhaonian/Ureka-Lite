package io.keyu.urekalite.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.keyu.urekalite.R
import kotlinx.android.synthetic.main.activity_login.loginBtn
import kotlinx.android.synthetic.main.activity_login.signupLink

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginBtn.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            this.finish()
        }

        signupLink.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
            this.finish()
        }
    }
}