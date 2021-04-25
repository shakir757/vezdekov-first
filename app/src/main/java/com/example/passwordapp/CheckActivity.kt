package com.example.passwordapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CheckActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check)

        val mySharedPreferences = getSharedPreferences("sh", Context.MODE_PRIVATE)
        var enter = mySharedPreferences.getInt("enter", 0)

        if (enter == 1){
            val intent = Intent(this, EnterActivity::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}