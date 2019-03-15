package io.keyu.urekalite.view

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Fade
import io.keyu.urekalite.R
import io.keyu.urekalite.adapter.BookmarkGridViewAdapter
import io.keyu.urekalite.adapter.BookmarkViewHolder
import io.keyu.urekalite.model.PostListDataSource

class BookmarkGridFragment : Fragment(), BookmarkClickListener {
    override fun onBookmarkClicked(holder: BookmarkViewHolder, position: Int) {

        val kittenDetails = DetailsFragment.newInstance()

        // Note that we need the API version check here because the actual transition classes (e.g. Fade)
        // are not in the support library and are only available in API 21+. The methods we are calling on the Fragment
        // ARE available in the support library (though they don't do anything on API < 21)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            kittenDetails.sharedElementEnterTransition = DetailsTransition()
            kittenDetails.enterTransition = Fade()
            exitTransition = Fade()
            kittenDetails.sharedElementReturnTransition = DetailsTransition()
        }

        activity!!.supportFragmentManager
            .beginTransaction()
            .addSharedElement(holder.postImage, "kittenImage")
            .replace(R.id.homeContentContainer, kittenDetails)
            .addToBackStack(null)
            .commit()
    }

    private lateinit var staggeredGridLayoutManager: GridLayoutManager
    private lateinit var bookmarkGridViewAdapter: BookmarkGridViewAdapter
    private lateinit var staggeredGridView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.view_bookmark_grid, container, false)

        staggeredGridView = rootView.findViewById(R.id.staggeredGridView)
        staggeredGridView.setHasFixedSize(true)

        staggeredGridLayoutManager = GridLayoutManager(activity, 2)
        staggeredGridView.layoutManager = staggeredGridLayoutManager

        bookmarkGridViewAdapter = BookmarkGridViewAdapter(
            context!!,
            layoutInflater,
            PostListDataSource().postList!!,
            this
        ) // TODO: replace dummy data
        staggeredGridView.adapter = bookmarkGridViewAdapter

        return rootView
    }
}