package io.keyu.urekalite.adapter

import android.content.Context
import android.graphics.Typeface
import android.widget.Toast
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import io.keyu.urekalite.R
import android.app.AlertDialog
import android.view.MotionEvent

class BookmarkViewHolder(private val context: Context, itemView: View) :
    RecyclerView.ViewHolder(itemView),
    View.OnClickListener,
    View.OnLongClickListener,
    View.OnTouchListener {

    val postTitle: TextView
    val postImage: SimpleDraweeView
    val postAuthor: TextView
    val postText: TextView

    private lateinit var postPreviewWindow: AlertDialog
    private var isLongPressed = false

    init {
        itemView.setOnClickListener(this)
        itemView.setOnLongClickListener(this)
        itemView.setOnTouchListener(this)

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

    override fun onLongClick(view: View): Boolean {
        isLongPressed = true
        postPreviewWindow = AlertDialog.Builder(context).create()
        postPreviewWindow.setTitle("Reset...")
        postPreviewWindow.setMessage("R u sure?")
        postPreviewWindow.window?.attributes?.windowAnimations = R.style.PostPreviewAnimation
        postPreviewWindow.show()

        return true
    }

    override fun onTouch(view: View?, event: MotionEvent?): Boolean {
        view?.onTouchEvent(event)
        if (event?.action == MotionEvent.ACTION_UP && isLongPressed) {
            isLongPressed = false
            postPreviewWindow.dismiss()
        }
        return true
    }
}