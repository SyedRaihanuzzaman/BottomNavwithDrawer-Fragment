package org.freedu.navigation

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import org.freedu.navigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var navController = findNavController(R.id.fragment)
        binding.bottomNavigationView.setupWithNavController(navController)

        actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            R.string.nave_open,
            R.string.nave_close
        )
        actionBarDrawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Handle navigation item selection in Drawer
        binding.navView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            binding.drawerLayout.closeDrawers()

            // Navigate based on selected item
            when (menuItem.itemId) {
                R.id.homeFragment -> navController.navigate(R.id.homeFragment)
                R.id.person -> navController.navigate(R.id.person)
                R.id.settingFragment -> navController.navigate(R.id.settingFragment)
            }
            true
        }
    }

        override fun onOptionsItemSelected(item:MenuItem): Boolean {
            return if(actionBarDrawerToggle.onOptionsItemSelected(item)){
                true
            }else super.onOptionsItemSelected(item)
        }
    }