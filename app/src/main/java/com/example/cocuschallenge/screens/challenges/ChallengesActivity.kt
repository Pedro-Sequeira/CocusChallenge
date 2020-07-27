package com.example.cocuschallenge.screens.challenges

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.cocuschallenge.R
import com.example.cocuschallenge.databinding.ActivityChallengesBinding
import com.example.cocuschallenge.screens.users.USERNAME_KEY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChallengesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChallengesBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var username: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChallengesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        username = intent.getStringExtra(USERNAME_KEY)!!

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.challenges_container_fragment) as NavHostFragment
        navController = navHostFragment.navController

        setupBottomNavigationBar()
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_completed,
                R.id.navigation_authored
            )
        )

        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun setupBottomNavigationBar() {
        val bottomNavBar = binding.bottomNavigation
        bottomNavBar.setupWithNavController(navController)
    }
}