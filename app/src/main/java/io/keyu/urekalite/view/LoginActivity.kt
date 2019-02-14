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
import kotlinx.android.synthetic.main.activity_login.emailTextLayout
import kotlinx.android.synthetic.main.activity_login.passwordTextView
import kotlinx.android.synthetic.main.activity_login.passwordTextLayout

class LoginActivity : AppCompatActivity() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        compositeDisposable.addAll(
            RxTextView.textChanges(emailTextView)
                .map(this::isValidEmail)
                .distinctUntilChanged()
                .subscribe { isValid -> renderEmailValidationMsg(isValid) },

            RxTextView.textChanges(passwordTextView)
                .map(this::isValidPassword)
                .distinctUntilChanged()
                .subscribe { isValid -> renderPasswordValidationMsg(isValid) },

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

    private fun isValidEmail(email: CharSequence): Boolean {
        return (email.isNullOrBlank() || android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
    }

    private fun renderEmailValidationMsg(emailCorrect: Boolean) {
        if (emailCorrect) {
            emailTextLayout.isErrorEnabled = false
        } else {
            emailTextLayout.apply {
                isErrorEnabled = true
                error = "email does not look right 😰"
            }
        }
    }

    private fun isValidPassword(password: CharSequence): Boolean {
        return (password.isNullOrBlank() || (password.length in 6..32))
    }

    private fun renderPasswordValidationMsg(passwordCorrect: Boolean) {
        if (passwordCorrect) {
            passwordTextLayout.isErrorEnabled = false
        } else {
            passwordTextLayout.apply {
                isErrorEnabled = true
                error = "password does not look right 😰"
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}