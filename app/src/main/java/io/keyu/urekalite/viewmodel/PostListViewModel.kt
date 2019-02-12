package io.keyu.urekalite.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import io.keyu.urekalite.model.PostListRepository

class PostListViewModel(application: Application) : ViewModel() {
    private lateinit var postListRepository: PostListRepository
}