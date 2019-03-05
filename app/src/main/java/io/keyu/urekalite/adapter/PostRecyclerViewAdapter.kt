package io.keyu.urekalite.adapter

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.keyu.urekalite.UrekaLiteApplication.Companion.context
import io.keyu.urekalite.model.post.Post
import io.keyu.urekalite.service.Contract
import io.keyu.urekalite.view.PostView
import io.keyu.urekalite.view.ProfileActivity

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
            setMediaList(
                if (curPost.content.smallMediaPaths.isNullOrEmpty()) emptyList()
                else curPost.content.smallMediaPaths.map { mediaPath ->
                    "${Contract.UREKA_AWS}/post/$mediaPath/downloadMedia?mediaFidelity=Medium"
                }
            )
            setPostOwnerAvatar("${Contract.UREKA_AWS}/avatar/${curPost.content.userAvatar}/downloadMedia?mediaFidelity=Small")
            setPostText(curPost.content.text)
            setLikeState(curPost.liked)
            setBookmarkState(curPost.bookmarked)
        }
        holder.postView.setOnClickListener {
            val intent = Intent(context, ProfileActivity::class.java)
            intent.putExtra("PostData", curPost)
            intent.flags = FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }

    fun setPostList(postList: List<Post>) {
        this.postList = postList
        notifyDataSetChanged()
    }
}