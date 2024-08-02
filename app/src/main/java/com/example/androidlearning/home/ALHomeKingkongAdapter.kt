package com.example.androidlearning.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidlearning.R

// 金刚区 adapter
class ALHomeKingkongAdapter(val dataSource: List<ALHomeKingkongListItem>): RecyclerView.Adapter<ALHomeKingkongAdapter.ALHomeKingkongViewHolder>() {

    inner class ALHomeKingkongViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.k_kingkong_listcell_imageview)
        val textView = itemView.findViewById<TextView>(R.id.k_kingkong_listcell_textview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ALHomeKingkongViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.k_home_kingkong_list_cell, parent, false)
        return ALHomeKingkongViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

    // 绑定数据
    override fun onBindViewHolder(holder: ALHomeKingkongViewHolder, position: Int) {
        val item = dataSource[position]
        // 文本
        holder.textView.text = item.title
        // 图片
        Glide.with(holder.itemView.context)
            .load(item.imageURL)
            .into(holder.imageView)
    }

}