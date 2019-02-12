package io.keyu.urekalite.model

import androidx.lifecycle.MutableLiveData
import io.keyu.urekalite.service.PostDataService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class PostListRepository() {

    private var postListLiveData: MutableLiveData<List<Post>> = MutableLiveData()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getPostListLiveData(): MutableLiveData<List<Post>> {
        val postList: MutableList<Post> = ArrayList()
        val retrofitInstance = PostDataService.retrofit
        val postListObservable = retrofitInstance.getPosts()
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
