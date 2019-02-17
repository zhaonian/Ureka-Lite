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
import io.keyu.urekalite.model.post.Post
import io.keyu.urekalite.viewmodel.PostListViewModel

class PostListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeLayout: SwipeRefreshLayout
    private lateinit var postListViewModel: PostListViewModel
    private val postListAdapter = PostRecyclerViewAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.view_post_list, container, false)
        recyclerView = rootView.findViewById(R.id.postRecyclerView)
        recyclerView.apply {
            setHasFixedSize(true)
            addItemDecoration(VerticalSpaceItemDecoration(36))
            layoutManager = LinearLayoutManager(context)
            adapter = postListAdapter
        }

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
        postListViewModel.getPostList().observe(this, Observer<List<Post>> { resource ->
            //            Log.d("haha", PostListDataSource().postList!![0].content.title)
            postListAdapter.setPostList(resource)
            postListAdapter.notifyDataSetChanged()
        })
    }
}
