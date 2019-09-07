package io.keyu.urekalite.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import io.keyu.urekalite.viewmodel.ViewModelProviderFactory

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(
        factory: ViewModelProviderFactory
    ): ViewModelProvider.Factory
}
