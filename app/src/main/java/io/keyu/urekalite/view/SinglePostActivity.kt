package io.keyu.urekalite.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.keyu.urekalite.R
import kotlinx.android.synthetic.main.view_single_post.*

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
    }
}