package io.keyu.urekalite.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.keyu.urekalite.view.PostView

class PostViewHolder private constructor(val postView: PostView) :
    RecyclerView.ViewHolder(postView) {
    companion object {
        @JvmStatic
        fun from(parent: ViewGroup): PostViewHolder =
            PostViewHolder(PostView(parent.context))
    }
}
