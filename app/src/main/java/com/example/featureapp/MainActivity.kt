package com.example.featureapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.featureapp.databinding.ActivityMainBinding
import com.example.featureapp.utils.hideBottomNav
import com.example.featureapp.utils.showBottomNav
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        initBottomNavigationView()
    }


    private fun initBottomNavigationView() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.findNavController()
        navController.addOnDestinationChangedListener(this)
        binding.bottomNav.setupWithNavController(navController)
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        when (destination.id) {
            R.id.creditBookFragment, R.id.cashBookFragment, R.id.moreFragment,
            -> showBottomNav()
            else -> hideBottomNav()
        }
    }
}