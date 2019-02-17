package io.keyu.urekalite.service

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

object SharedPreferenceService {
    private const val UREKA_EMAIL = "username"
    private const val UREKA_TOKEN = "password"
    private const val UREKA_IS_LOGGEDIN = "loggedIn"

    private fun getSharedPreferences(ctx: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(ctx)
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
}