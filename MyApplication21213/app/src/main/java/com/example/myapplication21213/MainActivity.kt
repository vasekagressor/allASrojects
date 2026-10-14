package com.example.myapplication21213

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.Language

private val hexColor: Int
    get() = TODO()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val langs = listOf(Language("Kotlin", 0xff16a085.toString()),
                Language("Java", 0xff2980b9.toString()),
                Language("JavaScript", 0xff74c3c.toString()),
                Language("Python", 0xffd35400.toString()))
            Column {
                for (lang in langs) {
                    Row (modifier = Modifier.padding(10.dp).fillMaxWidth()){
                        Box(modifier = Modifier.size(50.dp).background(Color(hexColor)))
                        Text(text = lang.value, fontSize = 28.sp, modifier = Modifier.padding(10.dp))

                    }

                }
            }
        }
    }
}