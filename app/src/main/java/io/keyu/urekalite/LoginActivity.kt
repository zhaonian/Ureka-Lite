package io.keyu.urekalite

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.signupLink

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        signupLink.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
            this.finish()
        }
    }
}