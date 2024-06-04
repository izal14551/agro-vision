package com.capstone.agrovision.bookmark

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.capstone.agrovision.R
import com.capstone.agrovision.result.Result

class BookmarkAdapter(private val bookmarkList: List<Result>, private val onItemClickListener: (Result) -> Unit) :
    RecyclerView.Adapter<BookmarkAdapter.BookmarkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bookmark, parent, false)
        return BookmarkViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        val bookmark = bookmarkList[position]
        holder.savedImage.setImageResource(bookmark.imageUrl)
        holder.tvBookmark.text = bookmark.tvBookmark
        holder.tvDescResult.text = bookmark.description

        holder.itemView.setOnClickListener {
            onItemClickListener(bookmark)
        }
    }

    override fun getItemCount(): Int = bookmarkList.size

    class BookmarkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val savedImage: ImageView = itemView.findViewById(R.id.savedImage)
        val tvBookmark: TextView = itemView.findViewById(R.id.tvBookmark)
        val tvDescResult: TextView = itemView.findViewById(R.id.tvDescResult)
    }
}
