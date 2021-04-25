package com.example.passwordapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_password.*


class PasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)

        val mySharedPreferences = getSharedPreferences("sh", Context.MODE_PRIVATE)
        val editor = mySharedPreferences.edit()

        button_set_password.setOnClickListener {
            val password = edit_text_password.text.toString()
            when {
                password.isEmpty() -> {
                    Toast.makeText(this, "Пожалуйста введите пароль!", Toast.LENGTH_SHORT).show()
                }
                password.length < 4 -> {
                    Toast.makeText(this, "Введите пароль длинною в 4 символа!", Toast.LENGTH_SHORT).show()
                }
                password.length > 4 -> {
                    Toast.makeText(this, "Введите пароль длинною в 4 символа!", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    editor.putString("myPassword", password)
                    editor.putInt("enter", 1)
                    editor.apply()
                    Toast.makeText(this, "Пароль сохранен!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}