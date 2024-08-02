package com.example.androidlearning.home

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ALKingkongItemDecoration(
    private val left: Int,
    private val right: Int,
    private val top: Int,
    private val bottom: Int
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val leftMargin = dpToPx(left, parent.context)
        val rightMargin = dpToPx(right, parent.context)
        val topMargin = dpToPx(top, parent.context)
        val bottomMargin = dpToPx(bottom, parent.context)
        // 设置上下左右四个边距
        outRect.left = leftMargin
        outRect.right = rightMargin
        outRect.top = topMargin
        outRect.bottom = bottomMargin
    }

    // dp 转 px
    private fun dpToPx(dp: Int, context: Context): Int {
        val density = context.resources.displayMetrics.density
        return (dp * density).toInt()
    }
}