package com.capstone.agrovision.news

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.capstone.agrovision.R

class NewsActivity : AppCompatActivity() {

    private lateinit var rvNews: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var newsAdapter: NewsAdapter
    private val newsList = mutableListOf<News>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        rvNews = findViewById(R.id.rvNews)
        progressBar = findViewById(R.id.progressBar)

        // Initialize RecyclerView
        rvNews.layoutManager = LinearLayoutManager(this)
        newsAdapter = NewsAdapter(newsList)
        rvNews.adapter = newsAdapter

        // Load news data from API or database
        loadNewsData()
    }

    private fun loadNewsData() {
        // Simulate API call or database query
        newsList.add(News("News 1", "https://example.com/news1", "https://example.com/news1.jpg"))
        newsList.add(News("News 2", "https://example.com/news2", "https://example.com/news2.jpg"))
        newsList.add(News("News 3", "https://example.com/news3", "https://example.com/news3.jpg"))

        // Hide progress bar and notify adapter
        progressBar.visibility = View.GONE
        newsAdapter.notifyDataSetChanged()
    }
}