package io.keyu.urekalite.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.keyu.urekalite.R
import io.keyu.urekalite.model.post.Post

class BookmarkGridViewAdapter(
    private val context: Context,
    private val layoutInflater: LayoutInflater,
    private val itemList: List<Post>
) : RecyclerView.Adapter<BookmarkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(
            R.layout.view_bookmark_grid_item, null
        )
        return BookmarkViewHolder(context, layoutInflater, layoutView)
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        holder.postTitle.text = itemList[position].content.title
        holder.postImage.setImageURI("hehe")
        holder.postAuthor.text = itemList[position].content.userDisplayedName
        holder.postText.text = itemList[position].content.text
    }

    override fun getItemCount(): Int {
        return this.itemList.size
    }
}