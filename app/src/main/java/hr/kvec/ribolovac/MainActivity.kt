package hr.kvec.ribolovac

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v4.widget.TextViewCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.TextView
import hr.kvec.ribolovac.activities.RibeActivity
import hr.kvec.ribolovac.utils.Constants
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private var drawerLayout: DrawerLayout? = null
    private var drawerToggle: ActionBarDrawerToggle? = null
    private var navigationView: NavigationView? = null
    private var toolbar: Toolbar? = null

    private var userName: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        setView()

    }

    override fun onBackPressed() {

        if (drawerLayout!!.isDrawerOpen(GravityCompat.START)) {

            drawerLayout!!.closeDrawer(GravityCompat.START)
            return

        } else {

            startExit()

        }

    }

    override fun onResume() {

        super.onResume()

        this.setTitle(R.string.app_name)

    }

    private fun startModule(type: Int) {

        when (type) {

            Constants.module_ribe -> {

                startActivity<RibeActivity>()

            }

        }

    }

    private fun setView() {

        button2.setOnClickListener { startModule(Constants.module_ribe) }

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        if (supportActionBar != null) supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        drawerLayout = findViewById(R.id.main_drawer_layout)
        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerToggle!!.syncState()

        navigationView = findViewById(R.id.main_navigation_view)
        navigationView!!.setNavigationItemSelectedListener { item ->
            val handler = Handler()
            handler.postDelayed({
                when (item.itemId) {

                    R.id.navigation_settings -> startSettings()

                    R.id.navigation_exit -> startExit()

                }
            }, 300)

            item.isChecked = true
            drawerLayout!!.closeDrawers()

            true
        }

    }

    private fun startSettings() {

        toast("Settings from function")

    }

    private fun startExit() {

        toast("Exit from function")

    }
}
