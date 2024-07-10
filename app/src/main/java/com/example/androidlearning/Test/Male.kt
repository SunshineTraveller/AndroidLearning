package com.example.androidlearning.Test

import android.util.Log
import com.example.androidlearning.lmTag

open class Male(name: String, age: Int, gender: Int = 1, var height: Float): Person(name, age, 1) {

    override fun sayHello() {
        super.sayHello()
        Log.i(lmTag, "by the way, I am $height meters tall")
    }
}