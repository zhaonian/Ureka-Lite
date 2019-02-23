package io.keyu.urekalite.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import io.keyu.urekalite.R
import io.keyu.urekalite.model.SearchUser

class UserHorizontalScrollView : HorizontalScrollView {
    @JvmOverloads
    constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
    ) : super(context, attrs, defStyleAttr)

    private val linearLayout: LinearLayout

    init {
        View.inflate(context, R.layout.view_user_list, this)
        linearLayout = findViewById(R.id.linearLayout)
    }

    fun setUserSearchList(userList: List<SearchUser>) {
        for (user in userList) {
            var userSmallView = UserSmallView(context)
            userSmallView.setUserImage(user.avatar)
            linearLayout.addView(userSmallView)
        }
    }
}