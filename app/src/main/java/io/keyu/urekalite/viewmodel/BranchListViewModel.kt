package io.keyu.urekalite.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.keyu.urekalite.model.BranchListRepository
import io.keyu.urekalite.model.post.Branch

class BranchListViewModel : ViewModel() {

    private var branchListRepository: BranchListRepository = BranchListRepository()

    fun getBranchList(): MutableLiveData<List<Branch>> {
        return branchListRepository.getBranchListLiveData()
    }

    fun clear() {
        branchListRepository.clear()
    }
}