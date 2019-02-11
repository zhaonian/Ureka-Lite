package io.keyu.urekalite.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import io.keyu.urekalite.adapter.PostRecyclerViewAdapter
import io.keyu.urekalite.R
import io.keyu.urekalite.model.Post
import io.keyu.urekalite.service.PostDataService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostListFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater.inflate(R.layout.view_post_list, container, false)
        getPostList()
        recyclerView = rootView.findViewById(R.id.postRecyclerView)
        return rootView
    }

    override fun onRefresh() {
        getPostList()
    }

    private fun getPostList() {
        val retrofitInstance = PostDataService.retrofit

        val call: Call<List<Post>> = retrofitInstance.getPosts()

        call.enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<List<Post>>?, response: Response<List<Post>>?) {
                if (response != null && response.isSuccessful && response.body() != null) {
                    recyclerView.apply {
                        // use this setting to improve performance if you know that changes
                        // in content do not change the layout size of the RecyclerView
                        setHasFixedSize(true)

                        // space between items
                        addItemDecoration(VerticalSpaceItemDecoration(36))

                        // use a linear layout manager
                        layoutManager = LinearLayoutManager(context)

                        val viewAdapter = PostRecyclerViewAdapter(response.body() ?: emptyList())
                        recyclerView.adapter = viewAdapter
                    }
                }
            }
        })
    }
}