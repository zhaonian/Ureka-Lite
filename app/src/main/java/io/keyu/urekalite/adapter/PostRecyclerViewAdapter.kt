package io.keyu.urekalite.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.keyu.urekalite.R
import io.keyu.urekalite.model.post.Post
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
            setPostOwnerAvatar(R.mipmap.ic_launcher_round)
            setPostText(curPost.content.text)
            setPostImage(curPost.content.smallMediaPaths[0])
            setLikeState(curPost.liked)
            setBookmarkState(curPost.bookmarked)
        }
    }

    fun setPostList(postList: List<Post>) {
        this.postList = postList
    }
}