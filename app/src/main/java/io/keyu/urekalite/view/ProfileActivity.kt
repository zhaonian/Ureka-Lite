package io.keyu.urekalite.view

import com.google.android.material.snackbar.Snackbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.toolbar
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import io.keyu.urekalite.R

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_material)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
            finish()
        }

        val collapsingToolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)
        val appBarLayout = findViewById<AppBarLayout>(R.id.app_bar)
        appBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            var isShow = true
            var scrollRange = -1

            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.title = "Zhaonian Luan"
                    isShow = true
                } else if (isShow) {
                    collapsingToolbarLayout.title =
                        " " // note there should a space between double quote otherwise it wont work
                    isShow = false
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_profile, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        // no inspection SimplifiableIfStatement
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }
}