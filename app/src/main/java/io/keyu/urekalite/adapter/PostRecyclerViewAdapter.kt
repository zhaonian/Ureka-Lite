package io.keyu.urekalite.adapter

import android.graphics.Color
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.keyu.urekalite.model.post.Post
import io.keyu.urekalite.service.Contract
import io.keyu.urekalite.view.PostView

class PostRecyclerViewAdapter : RecyclerView.Adapter<PostViewHolder>() {

    private var postList: List<Post> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        // create a new view
        val postView = PostView(parent.context)
        // set the view's size, margins, paddings and layout parameters
        return PostViewHolder.from(postView)
    }

    override fun getItemCount(): Int = postList.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val curPost = postList[position]
        holder.postView.apply {
            setPostOwnerDisplayName(curPost.content.userDisplayedName)
            setPostOwnerRole(curPost.content.role)
            setColors(
                intArrayOf(
                    Color.rgb(239, 85, 85),
                    Color.rgb(239, 85, 85),
                    Color.rgb(110, 49, 89),
                    Color.rgb(1, 188, 212)
                )
            )
            setPostOwnerAvatar("${Contract.UREKA_AWS}/avatar/${curPost.content.userAvatar}/downloadMedia?mediaFidelity=Small")
            setPostText(curPost.content.text)
            setPostImage(
                if (!curPost.content.smallMediaPaths.isNullOrEmpty())
                    "${Contract.UREKA_AWS}/post/${curPost.content.smallMediaPaths[0]}/downloadMedia?mediaFidelity=Original"
                else ""
            )
            setLikeState(curPost.liked)
            setBookmarkState(curPost.bookmarked)
        }
    }

    fun setPostList(postList: List<Post>) {
        this.postList = postList
    }
}