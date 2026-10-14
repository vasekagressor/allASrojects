package com.vasek.pergaev

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val photo: ImageView = findViewById(R.id.photoImageView)
        val name: TextView = findViewById(R.id.nameTextView)
        val position: TextView = findViewById(R.id.positionTextView)
        val phone: TextView = findViewById(R.id.phoneTextView)
        val email: TextView = findViewById(R.id.emailTextView)

        // === Анимация фото "выпрыгивание" сверху (как в лабе) ===
        photo.translationY = -1500f          // стартуем выше экрана
        photo.alpha = 0f                     // полностью прозрачное
        photo.animate()
            .translationY(0f)
            .alpha(1f)
            .setDuration(1200)
            .setInterpolator(OvershootInterpolator(1.5f)) // пружинящий эффект
            .setStartDelay(200)
            .start()

        // === Плавное появление текстовой информации ===
        val textViews = listOf(name, position, phone, email)
        textViews.forEachIndexed { index, view ->
            view.alpha = 0f
            view.translationY = 60f
            view.animate()
                .alpha(1f)
                .translationY(0f)
                .setDuration(700)
                .setStartDelay(700L + index * 250L)
                .start()
        }

        // === Лёгкое покачивание фото (по желанию) ===
        photo.postDelayed({
            photo.animate()
                .rotation(3f)
                .setDuration(400)
                .withEndAction {
                    photo.animate().rotation(-3f).setDuration(400)
                        .withEndAction {
                            photo.animate().rotation(0f).setDuration(300).start()
                        }.start()
                }.start()
        }, 1600)
    }
}