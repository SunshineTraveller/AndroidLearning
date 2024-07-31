package com.example.androidlearning.home

// 首页 列表数据局条目类型 抽象类
abstract class ALHomeListItem {
    abstract val type: Int
    abstract val title: String
    companion object {
        const val Banner = 1       // 轮播
        const val KingKong = 2     // 金刚区
        const val Marquee = 3      // 跑马灯
        const val WeekSum = 4      // 本周学情总结
        const val Schedule = 5     // 计划
    }
}

// banner item
data class ALHomeBannerItem(val data: String, val images: List<String>): ALHomeListItem() {
    override val type: Int
        get() = ALHomeListItem.Banner
    override val title: String
        get() = data
    val imageURLStrings: List<String>
        get() = images
}

// 金刚区 item
data class ALHomeKingKongItem(val data: String): ALHomeListItem() {
    override val type: Int
        get() = ALHomeListItem.KingKong
    override val title: String
        get() = data
}

// 跑马灯 item
data class ALHomeMarqueeItem(val data: String): ALHomeListItem() {
    override val type: Int
        get() = ALHomeListItem.Marquee
    override val title: String
        get() = data
}

// 周学情 item
data class ALHomeWeekSumItem(val data: String): ALHomeListItem() {
    override val type: Int
        get() = ALHomeListItem.WeekSum
    override val title: String
        get() = data
}

// listCell
data class ALHomeSchduleItem(val data: String): ALHomeListItem() {
    override val title: String
        get() = data
    override val type: Int
        get() = ALHomeListItem.Schedule
}

