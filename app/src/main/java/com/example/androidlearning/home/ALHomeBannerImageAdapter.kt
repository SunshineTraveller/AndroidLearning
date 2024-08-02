package com.example.androidlearning.home

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.example.androidlearning.R
import com.example.androidlearning.lmTag

// 首页 Banner adapter
// Banner Adapter
class ALHomeBannerImageAdapter(private val images: List<String>): RecyclerView.Adapter<ALHomeBannerImageAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.k_home_banner_imageview)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.k_home_banner_imageview_layout, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return images.count()
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(images[position])
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable?>,
                    isFirstResource: Boolean
                ): Boolean {
                    // 图片加载失败时的处理逻辑
                    Log.i(lmTag, "图片资源加载失败 $model")
                    return false // 返回 false 表示让 Glide 继续处理这个事件（例如显示占位符）
                }

                override fun onResourceReady(
                    resource: Drawable,
                    model: Any,
                    target: com.bumptech.glide.request.target.Target<Drawable?>?,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.i(lmTag, "图片资源准备就绪 ")
                    return false // 返回 false 表示让 Glide 继续处理这个事件（例如显示占位符）
                }

            })
            .into(holder.imageView)

    }
}