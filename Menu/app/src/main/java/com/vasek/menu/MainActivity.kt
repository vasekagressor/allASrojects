package com.vasek.menu

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var imageView: ImageView
    private lateinit var button: Button
    private lateinit var rootLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        imageView = findViewById(R.id.imageView)
        button = findViewById(R.id.button)
        rootLayout = findViewById(R.id.rootLayout)

        // ===== PopupMenu для ImageView (долгое нажатие) =====
        imageView.setOnLongClickListener {
            showImagePopupMenu(it)
            true
        }

        // ===== PopupMenu для Button (долгое нажатие) =====
        button.setOnLongClickListener {
            showButtonPopupMenu(it)
            true
        }

        // ===== PopupMenu для TextView (долгое нажатие) =====
        textView.setOnLongClickListener {
            showTextPopupMenu(it)
            true
        }
    }

    // =====================================================
    // =============== OptionsMenu (ActionBar) =============
    // =====================================================

    /** Создание меню */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    /** Обработка выбора пунктов меню */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                showToast(getString(R.string.menu_settings))
                true
            }
            R.id.action_about -> {
                showToast(getString(R.string.menu_about))
                true
            }
            R.id.action_help -> {
                showToast(getString(R.string.menu_help))
                true
            }
            R.id.action_save -> {
                showToast(getString(R.string.menu_save))
                true
            }
            R.id.action_exit -> {
                finish() // закрыть приложение
                true
            }
            // ===== Группа с radio-переключателями =====
            R.id.theme_light -> {
                item.isChecked = true
                rootLayout.setBackgroundColor(Color.parseColor("#F5F5F5"))
                textView.setTextColor(Color.parseColor("#212121"))
                showToast(getString(R.string.menu_theme_light))
                true
            }
            R.id.theme_dark -> {
                item.isChecked = true
                rootLayout.setBackgroundColor(Color.parseColor("#212121"))
                textView.setTextColor(Color.parseColor("#FFFFFF"))
                showToast(getString(R.string.menu_theme_dark))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // =====================================================
    // ================== PopupMenu ========================
    // =====================================================

    /** PopupMenu для ImageView */
    private fun showImagePopupMenu(view: View) {
        val popup = PopupMenu(this, view)
        popup.menuInflater.inflate(R.menu.popupmenu, popup.menu)

        popup.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.popup_like -> {
                    showToast(getString(R.string.popup_like))
                    true
                }
                R.id.popup_share -> {
                    showToast(getString(R.string.popup_share))
                    true
                }
                R.id.popup_info -> {
                    showToast(getString(R.string.popup_info))
                    true
                }
                R.id.popup_delete -> {
                    // пункт disabled — сюда не попадём
                    true
                }
                else -> false
            }
        }
        popup.show()
    }

    /** PopupMenu для Button */
    private fun showButtonPopupMenu(view: View) {
        val popup = PopupMenu(this, view)
        popup.menuInflater.inflate(R.menu.popupmenu_btn, popup.menu)

        popup.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.popup_copy -> {
                    textView.text = getString(R.string.popup_copy)
                    showToast(getString(R.string.popup_copy))
                    true
                }
                R.id.popup_paste -> {
                    textView.text = getString(R.string.popup_paste)
                    showToast(getString(R.string.popup_paste))
                    true
                }
                R.id.popup_cut -> {
                    textView.text = getString(R.string.popup_cut)
                    showToast(getString(R.string.popup_cut))
                    true
                }
                else -> false
            }
        }
        popup.show()
    }

    /** PopupMenu для TextView */
    private fun showTextPopupMenu(view: View) {
        val popup = PopupMenu(this, view)
        popup.menuInflater.inflate(R.menu.popupmenu_btn, popup.menu)

        popup.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.popup_copy -> {
                    textView.text = getString(R.string.popup_copy)
                    true
                }
                R.id.popup_paste -> {
                    textView.text = getString(R.string.popup_paste)
                    true
                }
                R.id.popup_cut -> {
                    textView.text = getString(R.string.popup_cut)
                    true
                }
                else -> false
            }
        }
        popup.show()
    }

    // =====================================================
    // ==================== Helper =========================
    // =====================================================

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}