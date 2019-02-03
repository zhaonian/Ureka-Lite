package io.keyu.urekalite

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PostViewHolder private constructor(val postView: PostView) :
    RecyclerView.ViewHolder(postView) {
    companion object {
        @JvmStatic
        fun from(parent: ViewGroup): PostViewHolder =
            PostViewHolder(PostView(parent.context))
    }
}
