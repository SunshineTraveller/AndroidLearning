package com.example.androidlearning.home

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.androidlearning.R
import com.to.aboomy.pager2banner.Banner

// 首页 Banner
class ALHomeBannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // Banner Cell
    val bannerCell: ConstraintLayout = itemView as ConstraintLayout
    // bannner View
    val bannerView: Banner = itemView.findViewById<Banner>(R.id.k_home_banner_view)
}

// 首页 金刚区
class ALHomeKingKongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // kingkongCell
    val kingkongCell: ConstraintLayout = itemView as ConstraintLayout
    // recyclerView
    val recyclerView: RecyclerView = itemView.findViewById(R.id.k_home_kingkong_recyclerview)
}

// 首页 跑马灯
class ALHomeMarqueeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // textView
    val textView: TextView = itemView.findViewById<TextView>(R.id.k_marqueue_textview)
}

// 首页 学情
class ALHomeWeekSumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // textView
    val textView: TextView = itemView.findViewById<TextView>(R.id.k_home_weeksum_cell_textview)
}

// 首页 计划
class ALHomeScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // textView
    val textView: TextView = itemView.findViewById<TextView>(R.id.k_home_schedule_celltextview)
}

