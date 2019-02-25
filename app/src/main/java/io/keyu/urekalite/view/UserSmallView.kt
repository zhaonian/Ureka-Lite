package io.keyu.urekalite.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.facebook.drawee.view.SimpleDraweeView
import com.google.android.material.card.MaterialCardView
import io.keyu.urekalite.R

class UserSmallView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    MaterialCardView(context, attrs, defStyleAttr) {

    private val userImage: SimpleDraweeView

    init {
        View.inflate(context, R.layout.view_user_small, this)
        userImage = findViewById(R.id.userSmallImage)
    }

    fun setUserImage(uri: String) {
        userImage.setImageURI(uri)
    }
}