package com.example.passwordapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mySharedPreferences = getSharedPreferences("sh", Context.MODE_PRIVATE)
        var enter = mySharedPreferences.getInt("enter", 0)

        if (enter == 1){
            button_go_to_change_password.text = "Сменить пароль"
        }

        button_go_to_change_password.setOnClickListener {
            val intent = Intent(this, PasswordActivity::class.java)
            startActivity(intent)
        }
    }
}