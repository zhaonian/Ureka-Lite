package io.keyu.urekalite

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Make sure this is before calling super.onCreate
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)

//        val user = UserDb.getCurrentUser()
        routeToAppropriatePage()
        finish()
    }

    private fun routeToAppropriatePage() {
        // Example routing
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
//        when {
//            user == null -> OnboardingActivity.start(this)
//            user.hasPhoneNumber() -> EditProfileActivity.start(this)
//            user.hasSubscriptionExpired() -> PaymentPlansActivity.start(this)
//            else -> HomeActivity.start(this)
//        }
    }
}