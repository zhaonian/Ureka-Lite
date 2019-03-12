package io.keyu.urekalite.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.keyu.urekalite.model.post.Branch
import io.keyu.urekalite.service.ChannelDataService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class BranchListRepository {

    private val TAG = BranchListRepository::class.simpleName

    private val branchListLiveData: MutableLiveData<List<Branch>> = MutableLiveData()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getBranchListLiveData(): MutableLiveData<List<Branch>> {
        val retrofitInstance = ChannelDataService.retrofit
        val branchListObservable = retrofitInstance.getBranchList()
        compositeDisposable.add(
            branchListObservable
                .map { it.branchList }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<List<Branch>>() {

                    override fun onError(e: Throwable) {
                        // moshi serialization error
                        Log.d(TAG, e.message)
                    }

                    override fun onNext(branch: List<Branch>) {
                        branchListLiveData.postValue(branch)
                    }

                    override fun onComplete() {
                    }
                })
        )
        return branchListLiveData
    }

    fun clear() {
        compositeDisposable.clear()
    }
}