package io.keyu.urekalite.di.post

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.keyu.urekalite.di.ViewModelKey
import io.keyu.urekalite.viewmodel.PostListViewModel

/**
 * Dependencies for all Post-related ViewModels.
 */
@Module
abstract class PostViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(PostListViewModel::class)
    abstract fun bindPostListViewModel(viewModel: PostListViewModel): ViewModel
}
