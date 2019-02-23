package io.keyu.urekalite

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class UrekaLiteApplication : Application() {

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