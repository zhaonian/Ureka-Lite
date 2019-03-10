package io.keyu.urekalite.view

import android.content.Intent
import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.keyu.urekalite.R
import io.keyu.urekalite.service.Contract
import io.keyu.urekalite.service.SharedPreferenceService
import kotlinx.android.synthetic.main.activity_home.drawer_layout
import kotlinx.android.synthetic.main.activity_home.top_navigation
import kotlinx.android.synthetic.main.app_bar_home.toolbar
import kotlinx.android.synthetic.main.app_bar_home.toolbarSearch
import kotlinx.android.synthetic.main.app_bar_home.bottom_navigation

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val TAG = HomeActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        bottom_navigation.selectedItemId = R.id.navHome

        top_navigation.setNavigationItemSelectedListener(this)
        val headerView = top_navigation.getHeaderView(0).apply {
            findViewById<SimpleDraweeView>(R.id.avatar).setImageURI(
                "${Contract.UREKA_AWS}/avatar/${SharedPreferenceService.getAvatar(context)}/downloadMedia?mediaFidelity=Small"
            )
            findViewById<TextView>(R.id.userDisplayedName).text =
                SharedPreferenceService.getDisplayedName(context)
            findViewById<TextView>(R.id.role).text =
                SharedPreferenceService.getOccupation(context)
        }
        headerView.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            drawer_layout.closeDrawer(GravityCompat.START)
        }
    }

    override fun onResume() {
        super.onResume()
        // remove the selected status on any item in drawer
        for (i in 0 until top_navigation.menu.size()) {
            top_navigation.menu.getItem(i).isChecked = false
        }
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navHome -> {
                toolbar.visibility = View.VISIBLE
                toolbarSearch.visibility = View.GONE
                var selectedFragment = PostListFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.homeContentContainer, selectedFragment)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navChannel -> {
                toolbar.visibility = View.VISIBLE
                toolbarSearch.visibility = View.GONE
                var selectedFragment = BranchListFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.homeContentContainer, selectedFragment)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navSearch -> {
                toolbar.visibility = View.GONE
                toolbarSearch.visibility = View.VISIBLE
                var selectedFragment = SearchFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.homeContentContainer, selectedFragment)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navNotification -> {
                toolbar.visibility = View.VISIBLE
                toolbarSearch.visibility = View.GONE
                return@OnNavigationItemSelectedListener true
            }
            R.id.navBookmark -> {
                toolbar.visibility = View.VISIBLE
                toolbarSearch.visibility = View.GONE
                var selectedFragment = BookmarkGridFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.homeContentContainer, selectedFragment)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.latest -> true
            R.id.popular -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_upgrade -> {
                // Handle the camera action
            }
            R.id.nav_terms -> {
                val intent = Intent(this, TermsWebViewActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_settings -> {
            }
            R.id.nav_share -> {
                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    type = "text/plain"
                    putExtra(
                        Intent.EXTRA_TEXT,
                        "Discover Science on Ureka at: https://play.google.com/store/apps/details?id=com.urekascience.ureka"
                    )
                }
                startActivity(shareIntent)
            }
            R.id.nav_send -> {
            }
            R.id.nav_logout -> {
                SharedPreferenceService.logoutUser(this)
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
