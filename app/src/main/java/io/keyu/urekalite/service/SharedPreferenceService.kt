package io.keyu.urekalite.service

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.content.Intent
import io.keyu.urekalite.view.LoginActivity

object SharedPreferenceService {
    private const val UREKA_USER = "ureka"
    private const val UREKA_ONBOARDING_DONE = "ureka_onboarding_done"
    private const val UREKA_IS_LOGGEDIN = "loggedIn"
    private const val UREKA_TOKEN = "token"
    const val UREKA_EMAIL = "email"
    const val UREKA_USERNAME = "username"
    const val UREKA_FULLNAME = "fullname"
    const val UREKA_AVATAR = "avatar"
    const val UREKA_OCCUPATION = "occupation"
    const val UREKA_ROLE = "role"

    private fun getSharedPreferences(ctx: Context): SharedPreferences {
        return ctx.getSharedPreferences(UREKA_USER, MODE_PRIVATE)
    }

    fun setUserInfo(
        ctx: Context,
        email: String,
        token: String,
        username: String,
        fullname: String,
        avatar: String,
        occupation: String,
        role: String
    ) {
        val editor = getSharedPreferences(ctx).edit()
        editor.putString(UREKA_EMAIL, email)
        editor.putString(UREKA_TOKEN, token)
        editor.putString(UREKA_USERNAME, username)
        editor.putString(UREKA_FULLNAME, fullname)
        editor.putString(UREKA_AVATAR, avatar)
        editor.putString(UREKA_OCCUPATION, occupation)
        editor.putString(UREKA_ROLE, role)
        editor.putBoolean(UREKA_IS_LOGGEDIN, true)
        editor.apply()
    }

    fun isOnboardingDone(ctx: Context): Boolean {
        return getSharedPreferences(ctx).getBoolean(UREKA_ONBOARDING_DONE, false)
    }

    fun setOnboardingStatus(ctx: Context, done: Boolean) {
        val editor = getSharedPreferences(ctx).edit()
        editor.putBoolean(UREKA_ONBOARDING_DONE, done)
        editor.apply()
    }

    fun getEmail(ctx: Context): String? {
        return getSharedPreferences(ctx).getString(UREKA_EMAIL, null)
    }

    fun getUserName(ctx: Context): String? {
        return getSharedPreferences(ctx).getString(UREKA_USERNAME, null)
    }

    fun getDisplayedName(ctx: Context): String? {
        return getSharedPreferences(ctx).getString(UREKA_FULLNAME, null)
    }

    fun getAvatar(ctx: Context): String? {
        return getSharedPreferences(ctx).getString(UREKA_AVATAR, null)
    }

    fun getOccupation(ctx: Context): String? {
        return getSharedPreferences(ctx).getString(UREKA_OCCUPATION, null)
    }

    fun getRole(ctx: Context): String? {
        return getSharedPreferences(ctx).getString(UREKA_ROLE, null)
    }

    fun getToken(ctx: Context): String? {
        return getSharedPreferences(ctx).getString(UREKA_TOKEN, null)
    }

    fun isLoggedIn(ctx: Context): Boolean {
        return getSharedPreferences(ctx).getBoolean(UREKA_IS_LOGGEDIN, false)
    }

    fun logoutUser(ctx: Context) {
        // Clear all data from Shared Preferences
        val editor = getSharedPreferences(ctx).edit()
        editor.putBoolean(UREKA_IS_LOGGEDIN, false)
        editor.putString(UREKA_TOKEN, "")
        editor.putString(UREKA_EMAIL, "")
        editor.putString(UREKA_USERNAME, "")
        editor.putString(UREKA_FULLNAME, "")
        editor.putString(UREKA_AVATAR, "")
        editor.putString(UREKA_ROLE, "")
        editor.putString(UREKA_OCCUPATION, "")
        editor.apply()

        // After logout redirect user to Login Activity
        val i = Intent(ctx, LoginActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP and Intent.FLAG_ACTIVITY_NEW_TASK)
        ctx.startActivity(i)
    }
}