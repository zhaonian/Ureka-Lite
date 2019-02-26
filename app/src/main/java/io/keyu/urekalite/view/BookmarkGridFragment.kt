package io.keyu.urekalite.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import io.keyu.urekalite.R
import io.keyu.urekalite.adapter.BookmarkGridViewAdapter
import io.keyu.urekalite.model.PostListDataSource

class BookmarkGridFragment : Fragment() {

    private lateinit var staggeredGridLayoutManager: StaggeredGridLayoutManager
    private lateinit var bookmarkGridViewAdapter: BookmarkGridViewAdapter
    private lateinit var staggeredGridView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.view_bookmark_grid, container, false)

        staggeredGridView = rootView.findViewById(R.id.staggeredGridView)
        staggeredGridView.setHasFixedSize(true)

        staggeredGridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        staggeredGridView.layoutManager = staggeredGridLayoutManager

        bookmarkGridViewAdapter = BookmarkGridViewAdapter(context!!, PostListDataSource().postList!!) // TODO: replace dummy data
        staggeredGridView.adapter = bookmarkGridViewAdapter

        return rootView
    }
}