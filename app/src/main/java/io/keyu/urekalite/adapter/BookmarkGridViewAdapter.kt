package io.keyu.urekalite.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import io.keyu.urekalite.R
import io.keyu.urekalite.model.post.Post
import io.keyu.urekalite.view.BookmarkClickListener

class BookmarkGridViewAdapter(
    private val context: Context,
    private val layoutInflater: LayoutInflater,
    private val itemList: List<Post>,
    private val bookmarkClickListener: BookmarkClickListener
) : RecyclerView.Adapter<BookmarkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.view_bookmark_grid_item, null)
        return BookmarkViewHolder(context, layoutInflater, layoutView)
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        holder.postTitle.text = itemList[position].content.title
        holder.postImage.setImageURI("hehe")
        holder.postAuthor.text = itemList[position].content.postOwnerDisplayedName
        holder.postText.text = itemList[position].content.text

        ViewCompat.setTransitionName(holder.postImage, position.toString() + "_image")
        holder.itemView.setOnClickListener { bookmarkClickListener.onBookmarkClicked(holder, position) }
    }

    override fun getItemCount(): Int {
        return this.itemList.size
    }
}