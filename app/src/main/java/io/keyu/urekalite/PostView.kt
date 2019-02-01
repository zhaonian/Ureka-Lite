package io.keyu.urekalite

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import com.google.android.material.card.MaterialCardView

class PostView : MaterialCardView {
    @JvmOverloads
    constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
    ) : super(context, attrs, defStyleAttr)

    private val postOwnerDisplayName: TextView
    private val postOwnerAvatar: ImageView
    private val postOwnerRole: TextView
    private val postImage: ImageView
    private val postText: TextView

    init {
        View.inflate(context, R.layout.view_post, this)
        postOwnerDisplayName = findViewById(R.id.postOwnerDisplayName)
        postOwnerAvatar = findViewById(R.id.postOwnerAvatar)
        postOwnerRole = findViewById(R.id.postOwnerRole)
        postImage = findViewById(R.id.postImage)
        postText = findViewById(R.id.postText)
    }

    fun setPostOwnerAvatar(@DrawableRes res: Int) {
        postOwnerAvatar.setImageResource(res)
    }

    fun setPostOwnerDisplayName(displayName: String) {
        postOwnerDisplayName.text = displayName
    }

    fun setPostOwnerRole(role: String) {
        postOwnerRole.text = role
    }

    fun setPostImage(@DrawableRes res: Int) {
        postImage.setImageResource(res)
    }

    fun setPostText(text: String) {
        postText.text = text
    }
}