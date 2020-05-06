package com.learn.growthcodelab.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity

class NavigationActivity : BaseActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        setSupportActionBar(findViewById(R.id.toolbar_navigation))
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_nav_host) as NavHostFragment
        val navController = navHostFragment.navController
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_navigation)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.destination_nav_home, R.id.destination_deep_link), drawerLayout)
        setupBottomNavigation(navController)
        setupDrawerNavigationView(navController)
        setupAppBar(navController, appBarConfiguration)

    }

    private fun setupBottomNavigation(navController: NavController) {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        bottomNavigationView?.setupWithNavController(navController)
    }

    private fun setupDrawerNavigationView(navController: NavController) {
        val navigationView = findViewById<NavigationView>(R.id.navigation_navigation)
        navigationView?.setupWithNavController(navController)
    }

    private fun setupAppBar(navController: NavController, appBarConfiguration: AppBarConfiguration) {
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val result = super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_navigaion_overflow, menu)
        return result
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val result = item.onNavDestinationSelected(findNavController(R.id.fragment_nav_host))
        return result || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.fragment_nav_host).navigateUp(appBarConfiguration)
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, NavigationActivity::class.java))
        }
    }
}