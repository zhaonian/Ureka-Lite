package io.keyu.urekalite.view

import android.os.Bundle
import android.app.Activity
import io.keyu.urekalite.R
import kotlinx.android.synthetic.main.activity_terms_webview.*

class TermsWebViewActivity : Activity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms_webview)

        webView.apply {
            settings.loadWithOverviewMode = true
            settings.useWideViewPort = true
            settings.builtInZoomControls = true
            loadUrl("https://ureka.science/TermsOfService.html")
        }
    }
}