package io.keyu.urekalite.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.keyu.urekalite.model.post.Post
import io.keyu.urekalite.service.PostDataService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostListRepository {

    @Inject lateinit var postDataService: PostDataService
    private val postListLiveData: MutableLiveData<Resource<List<Post>>> = MutableLiveData()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getPostListLiveData(): MutableLiveData<Resource<List<Post>>> {
        val postList: MutableList<Post> = ArrayList()
        val postListObservable = postDataService.getPosts()
        compositeDisposable.add(
            postListObservable
                .flatMapIterable { it }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<Post>() {

                    override fun onStart() {
                        super.onStart()
                        postListLiveData.value = (Resource(Status.LOADING, null, null))
                    }

                    override fun onError(e: Throwable) {
                        // network error
                        postListLiveData.value = (Resource(Status.ERROR, null, e.message))
                        // moshi serialization error
                        Log.d(TAG, e.message)
                    }

                    override fun onNext(post: Post) {
                        postList.add(post)
                    }

                    override fun onComplete() {
                        postListLiveData.value = (Resource(Status.SUCCESS, postList))
                    }
                })
        )
        return postListLiveData
    }

    fun clear() {
        compositeDisposable.clear()
    }

    companion object {
        const val TAG = "PostListRepository"
    }
}
