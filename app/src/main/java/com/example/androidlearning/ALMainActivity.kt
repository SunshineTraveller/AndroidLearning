package com.example.androidlearning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidlearning.Test.PrimaryData

val lmTag: String = "LMDebug"

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