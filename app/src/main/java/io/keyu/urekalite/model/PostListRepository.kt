package io.keyu.urekalite.model

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import io.keyu.urekalite.UrekaLiteApplication.Companion.context
import io.keyu.urekalite.model.post.Post
import io.keyu.urekalite.service.PostDataService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class PostListRepository {

    private val TAG = PostListRepository::class.simpleName

    private val postListLiveData: MutableLiveData<List<Post>> = MutableLiveData()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getPostListLiveData(): MutableLiveData<List<Post>> {
        val postList: MutableList<Post> = ArrayList()
        val retrofitInstance = PostDataService.retrofit
        val postListObservable = retrofitInstance.getPosts()
        compositeDisposable.add(
            postListObservable
                .flatMapIterable { it }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<Post>() {

                    override fun onError(e: Throwable) {
                        // moshi serialization error
                        Log.d(TAG, e.message)
                    }

                    override fun onNext(post: Post) {
                        Toast.makeText(context, post.content.title, Toast.LENGTH_LONG).show()
                        postList.add(post)
                    }

                    override fun onComplete() {
                        postListLiveData.postValue(postList)
                    }
                })
        )
        return postListLiveData
    }

    fun clear() {
        compositeDisposable.clear()
    }
}
