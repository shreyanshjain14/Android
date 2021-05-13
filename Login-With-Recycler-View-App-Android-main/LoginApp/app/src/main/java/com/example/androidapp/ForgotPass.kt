package com.example.androidapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_forgot_pass.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class ForgotPass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass)
        val sharedPref = getSharedPreferences("signUp", Context.MODE_PRIVATE)
        val editorPref = sharedPref.edit()

        reset_button.setOnClickListener {
            var newPass = newPass.text.toString()
            var confPass = con_pass.text.toString()

            if(newPass == confPass)
            {
                editorPref.apply{
                    putString("pass", newPass)
                    apply()
                }
                Toast.makeText(this, "Reset Successful", Toast.LENGTH_LONG).show()

            }
            else
            {
                Toast.makeText(this, "Password Did not Match", Toast.LENGTH_LONG).show()
            }
        }
        back_sign.setOnClickListener {
            var bckSign = Intent(this, MainActivity::class.java)
            startActivity(bckSign)
        }
    }
}