package io.keyu.urekalite.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import io.keyu.urekalite.R
import kotlinx.android.synthetic.main.view_single_post.*
import android.view.View

class SinglePostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_single_post)

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        like.setOnClickListener {
            Toast.makeText(this, "like", Toast.LENGTH_LONG).show()
        }
        bookmark.setOnClickListener {
            Toast.makeText(this, "bm", Toast.LENGTH_LONG).show()
        }
        link.setOnClickListener {
            Toast.makeText(this, "link", Toast.LENGTH_LONG).show()
        }
        share.setOnClickListener {
            Toast.makeText(this, "share", Toast.LENGTH_LONG).show()
        }

        nestedScrollView.setOnScrollChangeListener { v: NestedScrollView?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
            // Scroll Down
            if (scrollY > oldScrollY) {
                window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        or View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        or View.SYSTEM_UI_FLAG_IMMERSIVE)
            }
            // Scroll Up
            else if (scrollY < oldScrollY) {
                window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
            }
        }
    }
}