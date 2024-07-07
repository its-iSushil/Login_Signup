package com.kotlin.assignment_no_three

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText

class Register_Activity : AppCompatActivity() {
    lateinit var mobile:TextInputEditText
    lateinit var pass:TextInputEditText
    lateinit var confirm_pass:TextInputEditText
    lateinit var email:TextInputEditText
    lateinit var location:TextInputEditText
    private lateinit var sharedPreferences: SharedPreferences
    lateinit var name:TextInputEditText
    lateinit var btn_Register:AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this,R.color.white)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_register)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        mobile=findViewById(R.id.textInputEditTextMobile)
        pass=findViewById(R.id.textInputEditTextPassword)
        confirm_pass=findViewById(R.id.textInputEditTextCinfirmPassword)
        email=findViewById(R.id.textInputEditTextEmail)
        location=findViewById(R.id.textInputEditTextAddress)
        name=findViewById(R.id.textInputEditTextName)
        btn_Register=findViewById(R.id.btnRegister)

        btn_Register.setOnClickListener {

            if(mobile.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty() && confirm_pass.text.toString().isNotEmpty()
                && email.text.toString().isNotEmpty() && location.text.toString().isNotEmpty() && name.text.toString().isNotEmpty()){

                if(pass.text.toString().length >= 4){
                    if(pass.text.toString() == confirm_pass.text.toString()){
                        Toast.makeText(this,"Registered Successfully",Toast.LENGTH_SHORT).show()
                        sharedPreferences.edit().putString("Password",pass.text.toString()).apply()
                        sharedPreferences.edit().putString("Mobile",mobile.text.toString()).apply()
                        val intent = Intent(this@Register_Activity, LogInActivity::class.java)
                        startActivity(intent)
                        finish()

                    }else{
                        Toast.makeText(this,"Password Doesn't Match",Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(this,"Password should have at least 4 characters ",Toast.LENGTH_SHORT).show()
                }
            }  else{
                Toast.makeText(this,"Please enter fields",Toast.LENGTH_SHORT).show()
            }


        }


    }
}