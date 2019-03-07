package io.keyu.urekalite.adapter

import android.content.Context
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import androidx.viewpager.widget.PagerAdapter
import io.keyu.urekalite.R
import android.widget.LinearLayout
import com.facebook.drawee.view.SimpleDraweeView

class MediaListViewPagerAdapter(private val context: Context) : PagerAdapter() {

    private var mediaList = emptyList<String>()

    override fun getCount(): Int {
        return mediaList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.view_media_list_viewpager_item, container, false)
        val postMedia = view.findViewById<SimpleDraweeView>(R.id.postImage)
        postMedia.setImageURI(mediaList[position])
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }

    fun setMediaList(media: List<String>) {
        mediaList = media
        notifyDataSetChanged()
    }
}
