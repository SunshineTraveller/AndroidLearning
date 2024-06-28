package com.example.androidlearning

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

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