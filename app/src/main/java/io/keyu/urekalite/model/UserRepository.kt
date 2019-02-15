package io.keyu.urekalite.model

import androidx.lifecycle.MutableLiveData
import io.keyu.urekalite.service.UserDataService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class UserRepository {

    private val userLiveData: MutableLiveData<Resource<User>> = MutableLiveData()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getUserLiveData(user: UserLoginRequest): MutableLiveData<Resource<User>> {
        val retrofitInstance: UserDataService = UserDataService.retrofit
        val userObservable: Observable<Response<User>> = retrofitInstance.loginUser(user)
        var userResource: Resource<User>? = null
        compositeDisposable.add(
            userObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<Response<User>>() {

                    override fun onStart() {
                        super.onStart()
                        userLiveData.postValue(Resource(Status.LOADING, null, null))
                    }

                    override fun onError(e: Throwable) {
                        // Network error
                        userResource = Resource(
                            Status.ERROR,
                            null,
                            e.message
                        )
                    }

                    override fun onNext(response: Response<User>) {
                        userResource = if (response.code() == 200) {
                            Resource(
                                Status.SUCCESS,
                                response.body()
                            )
                        } else {
                            Resource(
                                Status.ERROR,
                                response.body()
                            )
                        }
                    }

                    override fun onComplete() {
                        userLiveData.postValue(userResource)
                    }
                })
        )
        return userLiveData
    }

    fun clear() {
        compositeDisposable.clear()
    }
}