package com.example.androidapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val sharedPref = getSharedPreferences("signUp", Context.MODE_PRIVATE)
        val editorPref = sharedPref.edit()
        bt_sup.setOnClickListener {
            var name = s_name.text.toString()
            var email = s_email.text.toString()
            var phone = editTextPhone.text.toString()
            var password = s_pass.text.toString()
            var cnfPass = s_pass1.text.toString()
            if(password == cnfPass)
            {
                Toast.makeText(this, "Registered Succesfully", Toast.LENGTH_LONG).show()
                editorPref.apply{
                    putString("name", name)
                    putString("email", email)
                    putString("phone", phone)
                    putString("pass", password)
                    apply()
                }
            }
            else
            {
                Toast.makeText(this, "Password Did not Match", Toast.LENGTH_LONG).show()
            }



        }

        bt_sin.setOnClickListener {
            var signInIntent = Intent(this, MainActivity::class.java)
            startActivity(signInIntent)
        }
    }
}