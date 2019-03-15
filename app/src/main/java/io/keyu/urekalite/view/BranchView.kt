package io.keyu.urekalite.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import com.google.android.material.card.MaterialCardView
import io.keyu.urekalite.R

class BranchView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    MaterialCardView(context, attrs, defStyleAttr) {

    private val branchName: TextView

    init {
        View.inflate(context, R.layout.view_branch, this) // inflate first before set below attrs, otherwise NPE
        branchName = findViewById(R.id.text1)
    }

    fun setText(t: String) {
        branchName.text = t
    }
}