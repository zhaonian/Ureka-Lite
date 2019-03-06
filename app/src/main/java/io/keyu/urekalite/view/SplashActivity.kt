package io.keyu.urekalite.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.keyu.urekalite.R
import io.keyu.urekalite.service.SharedPreferenceService
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Make sure this is before calling super.onCreate
//        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            /* Create an Intent that will start the Menu-Activity. */
            routeToAppropriatePage()
            this@SplashActivity.finish()
            this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }, 800)
    }

    private fun routeToAppropriatePage() {
        when {
            SharedPreferenceService.isLoggedIn(applicationContext) -> {
                val intent = Intent(this, HomeActivity::class.java)
                // Closing all the Activities, and Add new Flag to start new Activity
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP and Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
            SharedPreferenceService.isOnboardingDone(this) -> {
                val intent = Intent(this, OnboardingActivity::class.java)
                startActivity(intent)
            }
            else -> {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
//        when {
//            user == null -> OnboardingActivity.start(this)
//            user.hasPhoneNumber() -> EditProfileActivity.start(this)
//            user.hasSubscriptionExpired() -> PaymentPlansActivity.start(this)
//            else -> HomeActivity.start(this)
//        }
    }
}