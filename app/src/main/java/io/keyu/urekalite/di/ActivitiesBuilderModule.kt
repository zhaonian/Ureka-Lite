package io.keyu.urekalite.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.keyu.urekalite.di.post.PostModule
import io.keyu.urekalite.di.post.PostViewModelModule
import io.keyu.urekalite.model.PostListRepository
import io.keyu.urekalite.view.HomeActivity
import io.keyu.urekalite.view.PostListFragment

@Module
abstract class ActivitiesBuilderModule {

    @ContributesAndroidInjector(
        modules = [PostViewModelModule::class, PostModule::class] // only scope this to PostListRepository
    )
    abstract fun contributeHomeActivity(): HomeActivity // a sub-component
}
