package io.keyu.urekalite.adapter

import android.graphics.Typeface
import android.widget.Toast
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import io.keyu.urekalite.R

class BookmarkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    val postTitle: TextView
    val postImage: SimpleDraweeView
    val postAuthor: TextView
    val postText: TextView

    init {
        itemView.setOnClickListener(this)
        postTitle = itemView.findViewById(R.id.postTitle)
        postTitle.setTypeface(null, Typeface.BOLD)

        postImage = itemView.findViewById(R.id.postImage)

        postAuthor = itemView.findViewById(R.id.postAuthor)
        postAuthor.setTypeface(null, Typeface.BOLD_ITALIC)

        postText = itemView.findViewById(R.id.postText)
    }

    override fun onClick(view: View) {
        Toast.makeText(
            view.context,
            "Clicked Position = $layoutPosition", Toast.LENGTH_SHORT
        ).show()
    }
}