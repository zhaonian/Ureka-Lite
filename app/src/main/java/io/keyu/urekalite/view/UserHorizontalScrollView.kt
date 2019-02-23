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
    private var userList: List<SearchUser> = listOf(
        SearchUser(1, ""),
        SearchUser(2, ""),
        SearchUser(3, ""),
        SearchUser(4, ""),
        SearchUser(5, ""),
        SearchUser(6, ""),
        SearchUser(7, ""),
        SearchUser(8, ""),
        SearchUser(9, ""),
        SearchUser(10, "")
    )

    init {
        View.inflate(context, R.layout.view_user_list, this)
        linearLayout = findViewById(R.id.linearLayout)
        for (user in userList) {
            var userSmallView = UserSmallView(context)
            userSmallView.setUserImage("hehe")
            linearLayout.addView(userSmallView)
        }
    }

    fun setUserSearchList(userList: List<SearchUser>) {
        this.userList = userList
    }
}