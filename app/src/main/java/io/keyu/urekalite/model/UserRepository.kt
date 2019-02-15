package io.keyu.urekalite.model

import androidx.lifecycle.MutableLiveData
import io.keyu.urekalite.service.UserDataService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class UserRepository {

    private val userLiveData: MutableLiveData<Resource<User>> = MutableLiveData()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getUserLiveData(user: UserLoginRequest): MutableLiveData<Resource<User>> {
        val retrofitInstance: UserDataService = UserDataService.retrofit
        val userObservable: Observable<User> = retrofitInstance.loginUser(user)
        var user: User? = null
        compositeDisposable.add(
            userObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<User>() {

                    override fun onStart() {
                        super.onStart()
                        userLiveData.postValue(Resource(Status.LOADING, user, null))
                    }

                    override fun onError(e: Throwable) {
                        // if some error happens in our data layer our app will not crash, we will
                        // get error here
                        user = null
                        userLiveData.postValue(
                            Resource(
                                Status.ERROR,
                                user,
                                e.message
                            )
                        )
                    }

                    override fun onNext(data: User) {
                        user = data
                    }

                    override fun onComplete() {
                        userLiveData.postValue(Resource(Status.SUCCESS, user, null))
                    }
                })
        )
        return userLiveData
    }

    fun clear() {
        compositeDisposable.clear()
    }
}