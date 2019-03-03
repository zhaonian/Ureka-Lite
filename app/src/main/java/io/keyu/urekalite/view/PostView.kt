package io.keyu.urekalite.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.airbnb.lottie.LottieAnimationView
import com.facebook.drawee.view.SimpleDraweeView
import com.google.android.material.card.MaterialCardView
import io.keyu.urekalite.R
import io.keyu.urekalite.adapter.MediaListViewPagerAdapter
import io.keyu.urekalite.service.ZoomOutPageTransformer

class PostView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    MaterialCardView(context, attrs, defStyleAttr) {

    private val postOwnerDisplayName: TextView
    private val postOwnerAvatar: SimpleDraweeView
    private val postOwnerRole: TextView
    private val postImage: SimpleDraweeView
    private val postMediaList: ViewPager
    private val postText: TextView
    private val likeLottieView: LottieAnimationView
    private val bookmarkLottieView: LottieAnimationView
    private val pagerAdapter = MediaListViewPagerAdapter(context)

    init {
        View.inflate(context, R.layout.view_post, this) // inflate first before set below attrs, otherwise NPE
        postOwnerDisplayName = findViewById(R.id.postOwnerDisplayName)
        postOwnerAvatar = findViewById(R.id.postOwnerAvatar)
        postOwnerRole = findViewById(R.id.postOwnerRole)
        postImage = findViewById(R.id.postImage)
        postMediaList = findViewById(R.id.viewPager)
        postMediaList.adapter = pagerAdapter
        postMediaList.setPageTransformer(true, ZoomOutPageTransformer())
        postText = findViewById(R.id.postText)
        likeLottieView = findViewById(R.id.likeLottieView)
        bookmarkLottieView = findViewById(R.id.bookmarkLottieView)

        likeLottieView.setOnClickListener {
            likePost()
        }

        bookmarkLottieView.setOnClickListener {
            bookmarkPost()
        }
    }

    fun setColors(colors: IntArray) {
        (postMediaList.adapter as MediaListViewPagerAdapter).setColorArray(colors)
    }

    fun setPostOwnerAvatar(uri: String) {
        postOwnerAvatar.setImageURI(uri)
    }

    fun setPostOwnerDisplayName(displayName: String) {
        postOwnerDisplayName.text = displayName
    }

    fun setPostOwnerRole(role: String) {
        postOwnerRole.text = role
    }

    fun setPostImage(uri: String) {
        postImage.setImageURI(uri)
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
        likeLottieView.playAnimation()
//        likeLottieView.progress = 1f
    }

    fun unlikePost() {
        likeLottieView.progress = 0f
    }

    fun bookmarkPost() {
        bookmarkLottieView.playAnimation()
//        bookmarkLottieView.progress = 1f
    }

    fun unbookmarkPost() {
        bookmarkLottieView.progress = 0f
    }
}