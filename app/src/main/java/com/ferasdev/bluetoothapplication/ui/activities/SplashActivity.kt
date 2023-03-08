package com.ferasdev.bluetoothapplication.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.ferasdev.bluetoothapplication.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Make a delay for waiting processing
        Handler(Looper.getMainLooper()).postDelayed({
          val fromSplashToMain = Intent(this@SplashActivity, MainActivity::class.java)
          startActivity(fromSplashToMain)
        }, 2000)
    }
}