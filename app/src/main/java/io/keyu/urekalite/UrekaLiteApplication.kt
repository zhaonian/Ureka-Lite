package io.keyu.urekalite

import com.facebook.drawee.backends.pipeline.Fresco
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.keyu.urekalite.di.DaggerAppComponent

class UrekaLiteApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        context = this
    }

    companion object {
        lateinit var context: UrekaLiteApplication
            private set
    }
}
