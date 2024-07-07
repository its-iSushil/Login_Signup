package com.kotlin.assignment_no_three

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.log

class LogInActivity : AppCompatActivity() {

    lateinit var mobileNumber:TextInputEditText
    lateinit var password:TextInputEditText
    lateinit var logIN:AppCompatButton
    private lateinit var sharedPreferences: SharedPreferences
    lateinit var tv_forgot_password:TextView
    lateinit var tv_register:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this,R.color.white)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedIn=sharedPreferences.getBoolean("isLoggedIn",false)
        val Mobile=sharedPreferences.getString("Mobile","1234567890")
        val Password=sharedPreferences.getString("Password","Password")
        setContentView(R.layout.log_in_activity)
        if(isLoggedIn)
        {
            savePreferance()
            var intent = Intent(this@LogInActivity, EmptyActivity::class.java)
            startActivity(intent)
            finish()
        }

        mobileNumber=findViewById(R.id.textInputEditText)
        password=findViewById(R.id.textInputEditText1)
        logIN=findViewById(R.id.logIn)
        tv_forgot_password=findViewById(R.id.forgetPassword)
        tv_register=findViewById(R.id.signUp)

        logIN.setOnClickListener {
            if(mobileNumber.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()){
                if(mobileNumber.text.toString().equals(Mobile) && password.text.toString().equals(Password)){
                    savePreferance()
                    Toast.makeText(this,"Successfully Logged In",Toast.LENGTH_SHORT).show()
                    val intent=Intent(this@LogInActivity,EmptyActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else{
                    Toast.makeText(this,"Incorrect Password",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"Please enter fields",Toast.LENGTH_SHORT).show()
            }
        }

        tv_forgot_password.setOnClickListener {
            val intent=Intent(this@LogInActivity,Forgot_Password::class.java)
            startActivity(intent)
            finish()
        }

        tv_register.setOnClickListener {
            val intent=Intent(this@LogInActivity,Register_Activity::class.java)
            startActivity(intent)
            finish()
        }

    }
    fun savePreferance(){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()

    }
}