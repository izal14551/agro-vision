// TimelineActivity.kt
package com.capstone.agrovision.timeline

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.capstone.agrovision.HomeActivity
import com.capstone.agrovision.R
import com.capstone.agrovision.SettingsActivity
import com.capstone.agrovision.upload.TimelineAdapter
import com.capstone.agrovision.upload.Upload
import com.capstone.agrovision.upload.UploadActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TimelineActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timeline)

        val recyclerView: RecyclerView = findViewById(R.id.rvTimeline)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TimelineAdapter(getUploads())

        setupBottomNavigation()

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this, UploadActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupBottomNavigation() {
        bottomNavigationView = findViewById(R.id.menuBar)
        bottomNavigationView.selectedItemId = R.id.timeline
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    navigateTo(HomeActivity::class.java)
                    true
                }
                R.id.timeline -> true
                R.id.settings -> {
                    navigateTo(SettingsActivity::class.java)
                    true
                }
                else -> false
            }
        }
        // Tambahkan ini di setiap Activity, ganti 'R.color.menu_icon_color_selector' dengan warna yang sesuai
        bottomNavigationView.itemIconTintList = ContextCompat.getColorStateList(this, R.color.menu_icon_color_selector)
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

    private fun getUploads(): List<Upload> {
        // Dummy data
        return listOf(
            Upload("User1", "2 hours ago", "This is the first Upload", R.drawable.ic_launcher_background),
            Upload("User2", "5 hours ago", "This is the second Upload", R.drawable.ic_launcher_background),
            Upload("User3", "1 day ago", "This is the third Upload", R.drawable.ic_launcher_background)
        )
    }
}
