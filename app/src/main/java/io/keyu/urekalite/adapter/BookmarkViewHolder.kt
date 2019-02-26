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
import android.view.LayoutInflater
import android.view.MotionEvent

class BookmarkViewHolder(private val context: Context, private val layoutInflater: LayoutInflater, itemView: View) :
    RecyclerView.ViewHolder(itemView),
    View.OnClickListener,
    View.OnLongClickListener,
    View.OnTouchListener {

    val postTitle: TextView
    val postImage: SimpleDraweeView
    val postAuthor: TextView
    val postText: TextView

    private var postPreview: View = layoutInflater.inflate(R.layout.view_post_preview_dialog, null)
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

        postPreview.findViewById<TextView>(R.id.postTitle).text = postTitle.text
        postPreview.findViewById<TextView>(R.id.postText).text = postText.text
        postPreview.findViewById<TextView>(R.id.postAuthor).text = postAuthor.text
        postPreview.findViewById<SimpleDraweeView>(R.id.postImage).setImageURI("")
        // TODO: image quality to Original
        // TODO: image quality in the small Bookmark view should be medium / small

        isLongPressed = true
        postPreviewWindow = AlertDialog.Builder(context).setView(postPreview).create()
        postPreviewWindow.window?.decorView?.background?.alpha = 0
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