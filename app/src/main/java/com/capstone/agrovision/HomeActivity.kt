package com.capstone.agrovision

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.capstone.agrovision.bookmark.BookmarkActivity
import com.capstone.agrovision.news.NewsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val newsCard: CardView = findViewById(R.id.newsCard)
        val bookmarksCard: CardView = findViewById(R.id.bookmarksCard)
        val fabCamera: FloatingActionButton = findViewById(R.id.fabCamera) as FloatingActionButton
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.menuBar)

        newsCard.setOnClickListener {
            val intent = Intent(this, NewsActivity::class.java)
            startActivity(intent)
        }

        bookmarksCard.setOnClickListener {
            val intent = Intent(this, BookmarkActivity::class.java)
            startActivity(intent)
        }

        fabCamera.setOnClickListener {
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    // Stay on the home activity
                    true
                }
                R.id.timeline -> {
                    val intent = Intent(this, TimelineActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.settings -> {
                    val intent = Intent(this, SettingsActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}
