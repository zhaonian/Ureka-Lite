package io.keyu.urekalite.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.keyu.urekalite.model.BranchListRepository
import io.keyu.urekalite.model.post.ChannelGroupGroup

class BranchListViewModel : ViewModel() {

    private var branchListRepository: BranchListRepository = BranchListRepository()

    fun getBranchList(): MutableLiveData<List<ChannelGroupGroup>> {
        return branchListRepository.getBranchListLiveData()
    }

    fun clear() {
        branchListRepository.clear()
    }
}