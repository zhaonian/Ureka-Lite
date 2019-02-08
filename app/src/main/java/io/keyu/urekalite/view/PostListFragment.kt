package io.keyu.urekalite.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import io.keyu.urekalite.model.PostListDataSource
import io.keyu.urekalite.adapter.PostRecyclerViewAdapter
import io.keyu.urekalite.R

class PostListFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewAdapter: RecyclerView.Adapter<*>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater.inflate(R.layout.view_post_list, container, false)
        viewManager = LinearLayoutManager(context)
        viewAdapter =
            PostRecyclerViewAdapter(PostListDataSource().postList ?: emptyArray())

        recyclerView = rootView.findViewById<RecyclerView>(R.id.postRecyclerView).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // space between items
            addItemDecoration(VerticalSpaceItemDecoration(36))

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }
        return rootView
    }

    override fun onRefresh() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}