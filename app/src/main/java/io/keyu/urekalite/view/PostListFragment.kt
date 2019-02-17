package io.keyu.urekalite.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import io.keyu.urekalite.R
import io.keyu.urekalite.adapter.PostRecyclerViewAdapter
import io.keyu.urekalite.model.Post
import io.keyu.urekalite.viewmodel.PostListViewModel

class PostListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeLayout: SwipeRefreshLayout
    private lateinit var postListViewModel: PostListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.view_post_list, container, false)
        recyclerView = rootView.findViewById(R.id.postRecyclerView)
        postListViewModel = ViewModelProviders.of(this).get(PostListViewModel::class.java)
        getPostList()

        swipeLayout = rootView.findViewById(R.id.swipeLayout)
        swipeLayout.setColorSchemeResources(R.color.colorPrimary)
        swipeLayout.setOnRefreshListener {
            getPostList()
            swipeLayout.isRefreshing = false
        }
        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        postListViewModel.clear() // to avoid memory leak
    }

    private fun getPostList() {
        postListViewModel.getPostList().observe(this, Observer<List<Post>> {
            data -> renderRecyclerView(data)
        })
    }

    private fun renderRecyclerView(data: List<Post>) {
        recyclerView.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // space between items
            addItemDecoration(VerticalSpaceItemDecoration(36))

            // use a linear layout manager
            layoutManager = LinearLayoutManager(context)

            recyclerView.adapter = PostRecyclerViewAdapter(data)
        }
    }
}