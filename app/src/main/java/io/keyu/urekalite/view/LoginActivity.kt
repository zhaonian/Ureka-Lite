package io.keyu.urekalite.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import io.keyu.urekalite.R
import io.keyu.urekalite.model.User
import io.keyu.urekalite.viewmodel.UserViewModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.Observables
import kotlinx.android.synthetic.main.activity_login.loginBtn
import kotlinx.android.synthetic.main.activity_login.signupLink
import kotlinx.android.synthetic.main.activity_login.emailTextView
import kotlinx.android.synthetic.main.activity_login.emailTextLayout
import kotlinx.android.synthetic.main.activity_login.passwordTextView
import kotlinx.android.synthetic.main.activity_login.passwordTextLayout

class LoginActivity : AppCompatActivity() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

        // email validation
        val emailObservable = RxTextView.textChanges(emailTextView)
        val emailObservableDisposable = emailObservable.map(this::isValidEmail)
            .distinctUntilChanged()
            .subscribe { isValid -> renderEmailValidationMsg(isValid) }

        // password validation
        val passwordObservable = RxTextView.textChanges(passwordTextView)
        val passwordObservableDisposable = passwordObservable.map(this::isValidPassword)
            .distinctUntilChanged()
            .subscribe { isValid -> renderPasswordValidationMsg(isValid) }

        // loginBtn grey out when email || password not valid
        val loginBtnCombinedObservable: Observable<Boolean> =
            Observables.combineLatest(emailObservable, passwordObservable) { e: CharSequence, p: CharSequence ->
                !e.isBlank() && !p.isBlank() && isValidEmail(e) && isValidPassword(p)
            }
        val loginBtnCombinedObservableDisposable = loginBtnCombinedObservable.subscribe { isTouchable ->
            run {
                loginBtn.isEnabled = isTouchable
            }
        }

        // loginBtn onClick
        val loginBtnObservableDisposable = RxView.clicks(loginBtn).subscribe {
            loginUser()
            startActivity(Intent(this, HomeActivity::class.java))
            this.finish()
        }

        // singup link onClick
        val signupLinkObservableDisposable = RxView.clicks(signupLink).subscribe {
            startActivity(Intent(this, SignupActivity::class.java))
            this.finish()
        }

        compositeDisposable.addAll(
            emailObservableDisposable,
            passwordObservableDisposable,
            loginBtnCombinedObservableDisposable,
            loginBtnObservableDisposable,
            signupLinkObservableDisposable
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
        userViewModel.clear()
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

    private fun loginUser() {
        userViewModel.loginUser(emailTextView.text.toString(), passwordTextView.text.toString())
            .observe(this, Observer<User> {
                data -> Log.d("hehe", data.username + "-" + data.role)
        })
    }
}