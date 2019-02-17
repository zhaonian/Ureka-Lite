package io.keyu.urekalite.service

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.content.Intent
import io.keyu.urekalite.view.LoginActivity

object SharedPreferenceService {
    private const val UREKA_USER = "ureka"
    private const val UREKA_EMAIL = "username"
    private const val UREKA_TOKEN = "password"
    private const val UREKA_IS_LOGGEDIN = "loggedIn"

    private fun getSharedPreferences(ctx: Context): SharedPreferences {
        return ctx.getSharedPreferences(UREKA_USER, MODE_PRIVATE)
    }

    fun setLoginEmail(ctx: Context, email: String, token: String) {
        val editor = getSharedPreferences(ctx).edit()
        editor.putString(UREKA_EMAIL, email)
        editor.putString(UREKA_TOKEN, token)
        editor.putBoolean(UREKA_IS_LOGGEDIN, true)
        editor.apply()
    }

    fun getUserName(ctx: Context): String? {
        return getSharedPreferences(ctx).getString(UREKA_EMAIL, null)
    }

    fun getToken(ctx: Context): String? {
        return getSharedPreferences(ctx).getString(UREKA_TOKEN, null)
    }

    fun isLoggedIn(ctx: Context): Boolean {
        return getSharedPreferences(ctx).getBoolean(UREKA_IS_LOGGEDIN, false)
    }

    fun logoutUser(ctx: Context) {
        // Clear all data from Shared Preferences
        val editor = getSharedPreferences(ctx).edit().clear()
        editor.apply()

        // After logout redirect user to Login Activity
        val i = Intent(ctx, LoginActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP and Intent.FLAG_ACTIVITY_NEW_TASK)
        ctx.startActivity(i)
    }
}