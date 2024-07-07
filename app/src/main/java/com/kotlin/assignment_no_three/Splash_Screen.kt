package com.kotlin.assignment_no_three

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.core.content.ContextCompat

class Splash_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = ContextCompat.getColor(this,R.color.white)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        // This is used to hide the status bar and make
        // the splash screen as a full screen activity.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler().postDelayed({
            val intent=Intent(this@Splash_Screen,LogInActivity::class.java)
            startActivity(intent)
            finish()
        },2000)

    }
}