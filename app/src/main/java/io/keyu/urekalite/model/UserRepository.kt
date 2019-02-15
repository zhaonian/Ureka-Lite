package io.keyu.urekalite.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.keyu.urekalite.service.UserDataService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class UserRepository {

    private val userLiveData: MutableLiveData<User> = MutableLiveData()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getUserLiveData(user: UserLoginRequest): MutableLiveData<User> {
        val retrofitInstance: UserDataService = UserDataService.retrofit
        val userObservable: Observable<User> = retrofitInstance.loginUser(user)
        var user: User? = null
        compositeDisposable.add(
            userObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<User>() {
                    override fun onError(e: Throwable) {
                        // if some error happens in our data layer our app will not crash, we will
                        // get error here
                    }

                    override fun onNext(data: User) {
                        user = data
                    }

                    override fun onComplete() {
                        userLiveData.postValue(user)
                        Log.d("haha", user!!.username)
                    }
                })
        )
        return userLiveData
    }

    fun clear() {
        compositeDisposable.clear()
    }
}