package com.ferasdev.bluetoothapplication.ui.activities

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.ferasdev.bluetoothapplication.R
import com.ferasdev.bluetoothapplication.databinding.ActivityMainBinding
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    private lateinit var bluetoothManager:BluetoothManager
    private lateinit var bluetoothAdapter: BluetoothAdapter
    private val REQUEST_ENABLE_BT = 3

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val btmNav: BottomNavigationView = binding.btmNavActivityMain
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.btm_nav_activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_navigation_host_activity_main) as NavHostFragment

        navController = navHostFragment.navController

        NavigationUI.setupWithNavController(bottomNavigationView, navController)

        bluetoothManager = getSystemService(BluetoothManager::class.java)
        bluetoothAdapter = bluetoothManager.adapter

        if(bluetoothAdapter == null) {
            // Device doesn't support bluetooth
            Toast.makeText(this, "Your device doesn't support bluetooth", Toast.LENGTH_SHORT).show()
        } else {
            requestPermission()
        }

    }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        if (it) {
            // Permission Granted
            //isBluetoothEnabled()
        } else {
            // Permission Denied
        }
    }

//    private fun isBluetoothEnabled() {
//        if(!bluetoothAdapter.isEnabled) {
//            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
//            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT)
//        }
//    }

    private fun requestPermission() {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.BLUETOOTH
            ) == PackageManager.PERMISSION_GRANTED -> {
                // Permission granted
            }

            ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.BLUETOOTH
            ) -> {
                // Additional rational should be displayed

            }

            else -> {
                // Permission has not been asked yet
                requestPermissionLauncher.launch(Manifest.permission.BLUETOOTH)
            }
        }
    }
}