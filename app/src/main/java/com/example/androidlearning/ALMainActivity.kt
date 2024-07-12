package com.example.androidlearning

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.androidlearning.bottombar.ALTabbar
import com.example.androidlearning.home.ALHomeFragment
import com.example.androidlearning.mine.ALMineFragment
import com.example.androidlearning.plan.ALPlanFragment
import com.example.androidlearning.shop.ALShopFragment

val lmTag: String = "LMDebug"

class ALMainActivity: AppCompatActivity() {

    // 底部导航 Bar
    private lateinit var tabbar: ALTabbar

    // 四个Fragment
    private val fragments: List<Fragment> = listOf(
        ALHomeFragment(),
        ALPlanFragment(),
        ALShopFragment(),
        ALMineFragment()
    )

    /*
    * 这里要用下面只带一个参数的 onCreate(savedInstanceState: Bundle?) 的方法
    * 而不是 onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) 带两个参数的方法
    * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 设置主 Activity
        setContentView(R.layout.k_main_activity_layout)
        // 设置子控件
        setupSubviews()
    }

    // 设置子控件
    private fun setupSubviews() {
        // 设置底部导航 tabbar
        setupBottomNavigationView()
        replaceFragment(0)
        window.statusBarColor = android.graphics.Color.TRANSPARENT
    }

    // 设置底部 Tabbar
    private fun setupBottomNavigationView(): Unit {
        tabbar = findViewById(R.id.k_main_tabbar)
        tabbar.setOnItemClickListener(object: ALTabbar.ALTabarOnItemClickListener {
            override fun onClickItem(index: Int) {
                tabbar.selectedIndex(index)
                replaceFragment(index)
            }
        })
    }

    // 切换 Fragment
    private fun replaceFragment(index: Int) {
        // 这里也可以使用 supportFragmentManager 的 show & hide 方法，但是需要注意的是需要将其它 hide 掉
        supportFragmentManager.beginTransaction().replace(R.id.k_fragment_container, fragments[index]).commit()
    }
}




/*
class ALMainActivity: AppCompatActivity() {
    private final val testData: PrimaryData = PrimaryData()
    /*
    * 这里要用下面只带一个参数的 onCreate(savedInstanceState: Bundle?) 的方法
    * 而不是 onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) 带两个参数的方法
    * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.k_main_activity_layout)
        // 基本数据测试
        testData.primaryDataTest()
    }
}
*/
