package io.keyu.urekalite.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import io.keyu.urekalite.R
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_login.loginBtn
import kotlinx.android.synthetic.main.activity_login.signupLink
import kotlinx.android.synthetic.main.activity_login.emailTextView
import kotlinx.android.synthetic.main.activity_login.passwordTextView

class LoginActivity : AppCompatActivity() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        compositeDisposable.addAll(
            RxTextView.textChanges(emailTextView).subscribe(),
            RxTextView.textChanges(passwordTextView).subscribe(),
            RxView.clicks(loginBtn).subscribe {
                startActivity(Intent(this, HomeActivity::class.java))
                this.finish()
            },
            RxView.clicks(signupLink).subscribe {
                startActivity(Intent(this, SignupActivity::class.java))
                this.finish()
            }
        )
    }
}