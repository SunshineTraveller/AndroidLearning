package com.example.androidlearning.bottombar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import com.example.androidlearning.R


// 底部 Tabbar
class ALTabbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): LinearLayout(context, attrs, defStyleAttr) {

    // MARK: - Public
    // 更新选中项
    fun selectedIndex(index: Int) {
        // 点击已选中按钮不处理
        val currentSelectIndex = items.indexOfFirst {it.isSelected }
        if (currentSelectIndex == index) { return }

        items.forEachIndexed {idx, value ->
            value.isSelected = index == idx
            var icon = if (value.isSelected) { selectIconsArray[idx] } else { normalIconsArray[idx] }
            value.setCompoundDrawablesWithIntrinsicBounds(0,icon,0,0)
//            value.setTextColor()
        }
    }

    // MARK: - private
    private var onItemClickListener: ALTabarOnItemClickListener? = null

    // items
    private var items: MutableList<Button> = mutableListOf()

    // 未选中图片集合
    private var normalIconsArray: Array<Int> = arrayOf(R.mipmap.ic_tabbar_home_off,
        R.mipmap.ic_tabbar_plan_off,
        R.mipmap.ic_tabbar_shop_off,
        R.mipmap.ic_tabbar_mine_off
    )

    // 选中图片集合
    private var selectIconsArray: Array<Int> = arrayOf(R.mipmap.ic_tabbar_home_on,
        R.mipmap.ic_tabbar_plan_on,
        R.mipmap.ic_tabbar_shop_on,
        R.mipmap.ic_tabbar_mine_on
    )

    init {
        LayoutInflater.from(context).inflate(R.layout.k_main_bottom_bar_layout, this, true)
        val item1 = findViewById<Button>(R.id.k_main_tabbar_home_item)
        val item2 = findViewById<Button>(R.id.k_main_tabbar_plan_item)
        val item3 = findViewById<Button>(R.id.k_main_tabbar_shop_item)
        val item4 = findViewById<Button>(R.id.k_main_tabbar_mine_item)
        item1.setOnClickListener { onItemClickListener?.onClickItem(0) }
        item2.setOnClickListener { onItemClickListener?.onClickItem(1) }
        item3.setOnClickListener { onItemClickListener?.onClickItem(2) }
        item4.setOnClickListener { onItemClickListener?.onClickItem(3) }

        this.items.addAll(listOf(item1, item2, item3, item4))
        selectedIndex(0)
    }

    // 点击
    interface ALTabarOnItemClickListener {
        fun onClickItem(index: Int)
    }

    fun setOnItemClickListener(listener: ALTabarOnItemClickListener) {
        this.onItemClickListener = listener
    }

}