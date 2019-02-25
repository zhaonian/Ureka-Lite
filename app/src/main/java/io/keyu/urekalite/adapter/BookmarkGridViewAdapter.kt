package io.keyu.urekalite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.keyu.urekalite.R
import io.keyu.urekalite.model.post.Post

class BookmarkGridViewAdapter(private val itemList: List<Post>) : RecyclerView.Adapter<BookmarkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(
            R.layout.view_bookmark_grid_item, null
        )
        return BookmarkViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        holder.bookName.text = itemList[position].content.text
        holder.authorName.text = itemList[position].content.title
    }

    override fun getItemCount(): Int {
        return this.itemList.size
    }
}