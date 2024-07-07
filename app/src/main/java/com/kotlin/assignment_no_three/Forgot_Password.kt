package com.kotlin.assignment_no_three

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText

class Forgot_Password : AppCompatActivity() {
    lateinit var mobile:TextInputEditText
    lateinit var password:TextInputEditText
    lateinit var next:AppCompatButton
    private lateinit var sharedPreferences: SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this,R.color.white)
        setContentView(R.layout.activity_forgot_password)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        val Mobile=sharedPreferences.getString("Mobile","1234567890")
        mobile=findViewById(R.id.textInputEditText)
        password=findViewById(R.id.textInputEditText1)
        next=findViewById(R.id.next)

        next.setOnClickListener {
            if(mobile.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()){
                if(Mobile.equals(mobile.text.toString())){
                    if(password.text.toString().length>=4){
                        sharedPreferences.edit().putString("Mobile",mobile.text.toString()).apply()
                        sharedPreferences.edit().putString("Password",password.text.toString()).apply()
                        sharedPreferences.edit().putBoolean("isLoggedIn",false).apply()
                        Toast.makeText(this,"Password Updated",Toast.LENGTH_SHORT).show()
                        val intent= Intent(this@Forgot_Password,LogInActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(this,"Password should have at least 4 characters ",Toast.LENGTH_SHORT).show()
                    }

                }else{
                    Toast.makeText(this,"Invalid Mobile Number",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"Please enter fields",Toast.LENGTH_SHORT).show()
            }
        }

    }
}