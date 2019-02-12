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
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class PostListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeLayout: SwipeRefreshLayout
    private val postList: MutableList<Post> = ArrayList()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater.inflate(R.layout.view_post_list, container, false)
        getPostList()
        recyclerView = rootView.findViewById(R.id.postRecyclerView)

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
        compositeDisposable.clear() // to avoid memory leak
    }

    private fun getPostList() {
        val retrofitInstance = PostDataService.retrofit
        val postListObservable: Observable<List<Post>> = retrofitInstance.getPosts()
        compositeDisposable.add(
            postListObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMapIterable { it }
                .subscribeWith(object : DisposableObserver<Post>() {
                    override fun onError(e: Throwable) {
                        // if some error happens in our data layer our app will not crash, we will
                        // get error here
                    }

                    override fun onNext(post: Post) {
                        postList.add(post)
                    }

                    override fun onComplete() {
                        recyclerView.apply {
                            // use this setting to improve performance if you know that changes
                            // in content do not change the layout size of the RecyclerView
                            setHasFixedSize(true)

                            // space between items
                            addItemDecoration(VerticalSpaceItemDecoration(36))

                            // use a linear layout manager
                            layoutManager = LinearLayoutManager(context)

                            val viewAdapter = PostRecyclerViewAdapter(postList)
                            recyclerView.adapter = viewAdapter
                        }
                    }
                })
        )
    }
}