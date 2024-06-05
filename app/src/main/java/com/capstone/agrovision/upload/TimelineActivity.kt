package com.capstone.agrovision.timeline

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.capstone.agrovision.R
import com.capstone.agrovision.SettingsActivity
import com.capstone.agrovision.upload.TimelineAdapter
import com.capstone.agrovision.upload.Upload
import com.capstone.agrovision.upload.UploadActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TimelineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timeline)

        val recyclerView: RecyclerView = findViewById(R.id.rvTimeline)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TimelineAdapter(getUploads())

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.menuBar)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    finish() // Navigate back to home
                    true
                }
                R.id.timeline -> {
                    // Stay on the current activity
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

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this, UploadActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getUploads(): List<Upload> {
        // Dummy data
        return listOf(
            Upload("User1", "2 hours ago", "This is the first Upload", R.drawable.ic_launcher_background),
            Upload("User2", "5 hours ago", "This is the second Upload", R.drawable.ic_launcher_background),
            Upload("User3", "1 day ago", "This is the third Upload", R.drawable.ic_launcher_background)
        )
    }
}
