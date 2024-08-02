package com.example.androidlearning.home

//import android.R
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.example.androidlearning.R
import com.example.androidlearning.lmTag
import com.to.aboomy.pager2banner.Banner
import com.to.aboomy.pager2banner.IndicatorView
import com.to.aboomy.pager2banner.ScaleInTransformer


class ALHomeRecyclerAdapter(private val itemList: List<ALHomeListItem>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // itemView 类型
    override fun getItemViewType(position: Int): Int {
        val item = itemList[position]
        return item.type
    }

    // 创建新视图
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            // 轮播 Banner
            ALHomeListItem.Banner -> {
                val bannerCell = LayoutInflater.from(parent.context)
                    .inflate(R.layout.k_home_banner_cell, parent, false)
                return ALHomeBannerViewHolder(bannerCell)
            }

            // 金刚区
            ALHomeListItem.KingKong -> {
                val kingkongCell = LayoutInflater.from(parent.context)
                    .inflate(R.layout.k_home_kingkong_cell, parent, false)
                return ALHomeKingKongViewHolder(kingkongCell)
            }

            // 跑马灯
            ALHomeListItem.Marquee -> {
                val marqueeCell = LayoutInflater.from(parent.context)
                    .inflate(R.layout.k_home_marquee_layout, parent, false)
                return ALHomeMarqueeViewHolder(marqueeCell)
            }

            // 学情
            ALHomeListItem.WeekSum -> {
                val weekCell = LayoutInflater.from(parent.context)
                    .inflate(R.layout.k_home_weeksum_cell, parent, false)
                return ALHomeWeekSumViewHolder(weekCell)
            }

            // 计划
            ALHomeListItem.Schedule -> {
                val scheduleCell = LayoutInflater.from(parent.context)
                    .inflate(R.layout.k_home_schedule_cell, parent, false)
                return ALHomeScheduleViewHolder(scheduleCell)
            }

            else -> throw java.lang.IllegalArgumentException("Invalid view type")
        }
    }

    // 返回数据数项
    override fun getItemCount(): Int {
        return itemList.count()
    }

    // 绑定数据
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemData = itemList[position]
        when (holder.itemViewType) {
            // 轮播 Banner
            ALHomeListItem.Banner -> {
                val bannerViewHolder = holder as ALHomeBannerViewHolder
                val homeData = itemList[position] as ALHomeBannerItem
                val images = homeData.imageURLStrings
                setupBanner(bannerViewHolder.bannerCell, bannerViewHolder.bannerView, images)
            }

            // 金刚区
            ALHomeListItem.KingKong -> {
                val viewHolder = holder as ALHomeKingKongViewHolder
                val item = itemList[position] as ALHomeKingKongItem
                setupKingkong(viewHolder, listItem = item.list)
            }

            // 跑马灯
            ALHomeListItem.Marquee -> {
                val marqueeViewHolder = holder as ALHomeMarqueeViewHolder
                marqueeViewHolder.textView.text = itemData.title
            }

            // 学情
            ALHomeListItem.WeekSum -> {
                val weekViewHolder = holder as ALHomeWeekSumViewHolder
                weekViewHolder.textView.text = itemData.title
            }

            // 计划
            ALHomeListItem.Schedule -> {
                val scheduleViewHolder = holder as ALHomeScheduleViewHolder
                scheduleViewHolder.textView.text = itemData.title
            }
        }
    }

    // 设置Banner
    private fun setupBanner(bannerCell: ConstraintLayout, bannerView: Banner, images: List<String>) {
        val indicator = IndicatorView(bannerCell.context)
            .setIndicatorColor(Color.DKGRAY)
            .setIndicatorSelectorColor(Color.RED)
            .setIndicatorStyle(IndicatorView.IndicatorStyle.INDICATOR_DASH)

        val adapter = ALHomeBannerImageAdapter(images)
        bannerView.setIndicator(indicator).adapter = adapter
        bannerView.setPageMargin(32, 32).addPageTransformer(ScaleInTransformer())
    }

    private fun setupKingkong(viewHolder: ALHomeKingKongViewHolder, listItem: List<ALHomeKingkongListItem>) {

        // layoutManager
        val linearLayoutManager = LinearLayoutManager(viewHolder.kingkongCell.context)
        linearLayoutManager.orientation = RecyclerView.HORIZONTAL
        viewHolder.recyclerView.layoutManager = linearLayoutManager

        // Adapter
        val adapter = ALHomeKingkongAdapter(dataSource = listItem)
        viewHolder.recyclerView.adapter = adapter

        // itemDecoration
        val itemDecoration = ALKingkongItemDecoration(left = 0, right = 12, top = 16, bottom = 16)
        viewHolder.recyclerView.addItemDecoration(itemDecoration)
    }

}



