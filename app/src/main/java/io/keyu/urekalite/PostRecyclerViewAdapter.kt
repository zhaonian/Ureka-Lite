package io.keyu.urekalite

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PostRecyclerViewAdapter(private val myDataset: Array<Post>) :
    RecyclerView.Adapter<PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        // create a new view
        val postView = PostView(parent.context)
        // set the view's size, margins, paddings and layout parameters
        return PostViewHolder.from(postView)
    }

    override fun getItemCount(): Int = myDataset.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.postView.apply {
            setPostOwnerDisplayName(myDataset[position].user.displayName)
            setPostOwnerRole(myDataset[position].user.role)
            setPostOwnerAvatar(R.mipmap.ic_launcher_round)
            setPostText(myDataset[position].text)
            setPostImage(R.drawable.science)
        }
    }
}