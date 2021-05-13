package com.example.androidapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPref = getSharedPreferences("signUp", Context.MODE_PRIVATE)
        button.setOnClickListener {

            var un = editTextTextPersonName.text.toString()
            var pass = editTextTextPassword.text.toString()

            var email = sharedPref.getString("email", null)
            var password = sharedPref.getString("pass", null)
            Toast.makeText(this, email, Toast.LENGTH_LONG).show()
           if(un==email  && pass == password)
            {
                Toast.makeText(this, "LoggedinSuccesfully", Toast.LENGTH_LONG).show()
                var intentHere = Intent(this,MainActivity2::class.java)
                startActivity(intentHere)
            }
            else
            {
                Toast.makeText(this, "Either Username or Password is Wrong", Toast.LENGTH_LONG).show()
            }

        }
        bt_sign_up.setOnClickListener{
            var signUpIntent = Intent(this, SignUp::class.java)
            startActivity(signUpIntent)
        }
        ButtonFor.setOnClickListener {
            var nextPage = Intent(this, ForgotPass::class.java)
            startActivity(nextPage)
        }
            }
}