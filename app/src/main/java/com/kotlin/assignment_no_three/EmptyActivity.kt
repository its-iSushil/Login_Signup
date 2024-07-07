package com.kotlin.assignment_no_three

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat

class EmptyActivity : AppCompatActivity() {

    lateinit var logOut:AppCompatButton
    private lateinit var sharedPreferences: SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this,R.color.white)
        setContentView(R.layout.activity_empty)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        logOut=findViewById(R.id.logOut)

        logOut.setOnClickListener {
            sharedPreferences.edit().putBoolean("isLoggedIn",false).apply()
            val intent=Intent(this@EmptyActivity,LogInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}