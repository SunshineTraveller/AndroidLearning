package com.example.androidlearning

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity



class ALMainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.k_main_activity_layout)

        // 基本数据测试
        val test = PrimaryData()
        test.primaryDataTest()
    }
}