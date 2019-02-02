package io.keyu.urekalite

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import com.airbnb.lottie.LottieAnimationView
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
    private val likeLottieView: LottieAnimationView
    private val bookmarkLottieView: LottieAnimationView

    init {
        View.inflate(context, R.layout.view_post, this) // inflate first before set below attrs, otherwise NPE
        postOwnerDisplayName = findViewById(R.id.postOwnerDisplayName)
        postOwnerAvatar = findViewById(R.id.postOwnerAvatar)
        postOwnerRole = findViewById(R.id.postOwnerRole)
        postImage = findViewById(R.id.postImage)
        postText = findViewById(R.id.postText)
        likeLottieView = findViewById(R.id.likeLottieView)
        bookmarkLottieView = findViewById(R.id.bookmarkLottieView)

        likeLottieView.setOnClickListener {
            if (likeLottieView.progress == 1f)
                unlikePost()
            else
                likePost()
        }
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

    fun setLikeState(liked: Boolean) {
        likeLottieView.progress = if (liked) 1f else 0f
    }

    fun setBookmarkState(bookmarked: Boolean) {
        bookmarkLottieView.progress = if (bookmarked) 1f else 0f
    }

    fun likePost() {
        likeLottieView.progress = 1f
    }

    fun unlikePost() {
        likeLottieView.progress = 0f
    }

    fun bookmarkPost() {
        bookmarkLottieView.progress = 1f
    }

    fun unbookmarkPost() {
        bookmarkLottieView.progress = 0f
    }
}