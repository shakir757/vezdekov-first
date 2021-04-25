package com.example.passwordapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_enter.*

class EnterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter)

        val mySharedPreferences = getSharedPreferences("sh", Context.MODE_PRIVATE)
        val passC = mySharedPreferences.getString("myPassword", "9999")

        button_enter_password.setOnClickListener {
            val pass = edit_text_password_enter.text.toString()
            when {
                pass.isEmpty() -> {
                    Toast.makeText(this, "Пожалуйста введите пароль!", Toast.LENGTH_SHORT).show()
                }
                pass.length < 4 -> {
                    Toast.makeText(this, "Введите пароль длинною в 4 символа!", Toast.LENGTH_SHORT).show()
                }
                pass.length > 4 -> {
                    Toast.makeText(this, "Введите пароль длинною в 4 символа!", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    if (passC == pass){
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Неверный пароль!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}