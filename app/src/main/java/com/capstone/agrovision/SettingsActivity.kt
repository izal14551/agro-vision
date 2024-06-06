// SettingsActivity.kt
package com.capstone.agrovision

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.capstone.agrovision.timeline.TimelineActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class SettingsActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_settings)

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        bottomNavigationView = findViewById(R.id.menuBar)
        bottomNavigationView.selectedItemId = R.id.settings
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    navigateTo(HomeActivity::class.java)
                    true
                }

                R.id.timeline -> {
                    navigateTo(TimelineActivity::class.java)
                    true
                }

                R.id.settings -> true
                else -> false
            }
        }
        // Tambahkan ini di setiap Activity, ganti 'R.color.menu_icon_color_selector' dengan warna yang sesuai
        bottomNavigationView.itemIconTintList =
            ContextCompat.getColorStateList(this, R.color.menu_icon_color_selector)
    }

    private fun setupButtonListeners() {
        // TODO: Tambahkan setup button listeners jika diperlukan
    }

    private fun navigateTo(activityClass: Class<*>) {
        startActivity(Intent(this, activityClass))
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
}
