package com.capstone.agrovision.bookmark

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.capstone.agrovision.DetailResultActivity
import com.capstone.agrovision.R
import com.capstone.agrovision.result.Result

class BookmarkActivity : AppCompatActivity() {

    private lateinit var rvBookmark: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var bookmarkAdapter: BookmarkAdapter

    private var bookmarkList: MutableList<Result> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark)

        rvBookmark = findViewById(R.id.rvBookmark)
        progressBar = findViewById(R.id.progressBar)

        bookmarkAdapter = BookmarkAdapter(bookmarkList) { result ->
            val intent = Intent(this, DetailResultActivity::class.java)
            // Pass data to DetailResultActivity (optional)
            intent.putExtra("result_data", result)
            startActivity(intent)
        }

        rvBookmark.layoutManager = LinearLayoutManager(this)
        rvBookmark.adapter = bookmarkAdapter

        loadBookmarks()
    }

    private fun loadBookmarks() {
        progressBar.visibility = View.VISIBLE
        // Simulate loading data
        bookmarkList.add(Result(1, "Bookmark 1", "Description 1", R.drawable.ic_placeholder))
        bookmarkList.add(Result(2, "Bookmark 2", "Description 2", R.drawable.ic_placeholder))
        bookmarkList.add(Result(3, "Bookmark 3", "Description 3", R.drawable.ic_placeholder))

        bookmarkAdapter.notifyDataSetChanged()
        progressBar.visibility = View.GONE
    }
}
