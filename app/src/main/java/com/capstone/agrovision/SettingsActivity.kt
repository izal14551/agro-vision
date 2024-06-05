package com.capstone.agrovision

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.capstone.agrovision.bookmark.BookmarkActivity
import com.capstone.agrovision.news.NewsActivity
import com.capstone.agrovision.timeline.TimelineActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_settings)
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.menuBar)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    // Stay on the home activity
                    true
                }
                R.id.timeline -> {
                    val intent = Intent(this, TimelineActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.settings -> {
                    true
                }
                else -> false
            }
        }
    }
}
