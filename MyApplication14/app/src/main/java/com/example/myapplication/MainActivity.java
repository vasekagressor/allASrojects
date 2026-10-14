package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // подключаем наш XML

        // Находим элементы по id
        val btnClick = findViewById<Button>(R.id.btnClick)
        val editName = findViewById<EditText>(R.id.editName)  // нужно добавить id в XML
        val textHello = findViewById<TextView>(R.id.textHello)

                // Вешаем обработчик на кнопку
        btnClick.setOnClickListener {
            val name = editName.text.toString()
            if (name.isEmpty()) {
                Toast.makeText(this, "Введи имя!", Toast.LENGTH_SHORT).show()
            } else {
                textHello.text = "Привет, $name!"
            }
        }
    }
}