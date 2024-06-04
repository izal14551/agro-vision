package com.capstone.agrovision.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.capstone.agrovision.R

class NewsAdapter(private val newsList: List<News>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]
        holder.tvNews.text = news.title
        holder.tvUrl.text = news.url
        Glide.with(holder.itemView.context).load(news.image).into(holder.newsPict)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNews: TextView = itemView.findViewById(R.id.tvNews)
        val tvUrl: TextView = itemView.findViewById(R.id.tvUrl)
        val newsPict: ImageView = itemView.findViewById(R.id.newsPict)
    }
}