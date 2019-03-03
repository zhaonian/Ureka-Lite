package io.keyu.urekalite.adapter

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import androidx.viewpager.widget.PagerAdapter
import io.keyu.urekalite.R
import android.widget.TextView
import android.widget.LinearLayout

class MediaListViewPagerAdapter(private val context: Context) : PagerAdapter() {

    // list of titles
    var lst_title = arrayOf("COSMONAUT", "SATELITE", "GALAXY", "ROCKET")
    // list of descriptions
    var lst_description = arrayOf(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,"
    )
    // list of background colors
    private var lst_backgroundcolor = intArrayOf(
        Color.rgb(55, 55, 55), Color.rgb(55, 55, 55), Color.rgb(55, 55, 55), Color.rgb(55, 55, 55)
    )

    override fun getCount(): Int {
        return lst_title.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.view_media_list_viewpager_item, container, false)
        val layoutslide = view.findViewById(R.id.slidelinearlayout) as LinearLayout
        val txttitle = view.findViewById(R.id.txttitle) as TextView
        val description = view.findViewById(R.id.txtdescription) as TextView
        layoutslide.setBackgroundColor(lst_backgroundcolor[position])
        txttitle.text = lst_title[position]
        description.text = lst_description[position]
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }

    fun setColorArray(colors: IntArray) {
        lst_backgroundcolor = colors
        notifyDataSetChanged()
    }
}
