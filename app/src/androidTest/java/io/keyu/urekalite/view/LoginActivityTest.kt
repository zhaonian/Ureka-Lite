package io.keyu.urekalite.view

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.keyu.urekalite.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @Test fun loginButtonShowsUp() {
        val scenario = ActivityScenario.launch(LoginActivity::class.java)

        onView(withId(R.id.loginBtn)).check(matches(isDisplayed()))
    }
}