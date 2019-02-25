package io.keyu.urekalite.adapter

import android.widget.Toast
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.keyu.urekalite.R

class BookmarkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    var bookName: TextView
    var authorName: TextView

    init {
        itemView.setOnClickListener(this)
        bookName = itemView.findViewById(R.id.BookName)
        authorName = itemView.findViewById(R.id.AuthorName)
    }

    override fun onClick(view: View) {
        Toast.makeText(
            view.context,
            "Clicked Position = $position", Toast.LENGTH_SHORT
        ).show()
    }
}