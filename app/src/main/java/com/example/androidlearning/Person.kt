package com.example.androidlearning

import android.util.Log

// 基类 人类 需要 open 才能被继承
// gender: 性别 1 = 男， 2 = 女
open class Person(var name: String, var age: Int, var gender: Int) {

    // 打招呼
    open fun sayHello() {
        var genderString = "man"
        if (gender == 2) {
            genderString = "women"
        }
        Log.i(lmTag, "Hello, I am ${this.name}, I'm $age years old, and I am a kind $genderString")
    }
}