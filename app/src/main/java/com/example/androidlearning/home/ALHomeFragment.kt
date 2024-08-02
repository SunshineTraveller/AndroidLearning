package com.example.androidlearning.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidlearning.R

// 首页 Fragment
class ALHomeFragment : Fragment() {

    // MARK: - private
    // 列表
    private lateinit var homeRecyclerView: RecyclerView

    // 列表 Adapter 适配器
    private lateinit var homeAdapter: ALHomeRecyclerAdapter

    // 列表 LayoutManager
    private lateinit var layoutManager: RecyclerView.LayoutManager

    // XML 和 ALHomeFragment 文件绑定
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.k_home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 设置 RecyclerView
        homeRecyclerView = view.findViewById(R.id.k_home_recyclerview)

        // 设置 LayoutManager 并与 recyclerView 绑定
        layoutManager = LinearLayoutManager(context)
        homeRecyclerView.layoutManager = layoutManager

        // Mock 数据
        // banner 轮播图
        val imageURLStrings = listOf<String>(
            "https://aliresource.edstars.com.cn/xpad-parent/banner/1cb62864-5ae8-4f4a-8d33-81238ad6207e-1716199271406.png",
            "https://aliresource.edstars.com.cn/xpad-parent/banner/8f577fd5-674e-4678-b7ab-d94d9cd4d43e-1718268952530.png",
            "https://aliresource.edstars.com.cn/xpad-parent/banner/1cb62864-5ae8-4f4a-8d33-81238ad6207e-1716199271406.png",
            "https://aliresource.edstars.com.cn/xpad-parent/banner/8f577fd5-674e-4678-b7ab-d94d9cd4d43e-1718268952530.png",)


        // 金刚位数据
        val kingkongList = listOf<ALHomeKingkongListItem>(
            ALHomeKingkongListItem(imageURL = "https://static0.xesimg.com/baodian/parent-client/learning-toolbar/taskarrange@3x.png", title = "布置任务"),
            ALHomeKingkongListItem(imageURL = "https://static0.xesimg.com/baodian/parent-client/learning-toolbar/xiaosilearning@3x.png", "小思伴学"),
            ALHomeKingkongListItem(imageURL = "https://static0.xesimg.com/baodian/parent-client/learning-toolbar/learnweekly@3x.png", title = "学习周报"),
            ALHomeKingkongListItem(imageURL = "https://static0.xesimg.com/baodian/parent-client/learning-toolbar/toolresource@3x.png", title = "工具资源"),
            ALHomeKingkongListItem(imageURL = "https://static0.xesimg.com/baodian/parent-client/learning-toolbar/errorbook@3x.png", title = "错题本")
        )

        val items = listOf<ALHomeListItem>(
            ALHomeBannerItem(data = "我是轮播", images = imageURLStrings),
            ALHomeKingKongItem(data = "我是金刚区", list = kingkongList),
            ALHomeMarqueeItem(data = "我是跑马灯"),
            ALHomeWeekSumItem(data = "我是周报学情"),
            ALHomeSchduleItem(data = "sdfsf")
        )

        // 设置 adapter
        homeAdapter = ALHomeRecyclerAdapter(itemList = items)
        homeRecyclerView.adapter = homeAdapter
    }
}