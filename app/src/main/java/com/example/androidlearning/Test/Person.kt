package com.example.androidlearning.Test

import android.util.Log
import com.example.androidlearning.lmTag

interface AnyThing {
    var laugh: String
    fun learn()
}

// 基类 人类 需要 open 才能被继承
// gender: 性别 1 = 男， 2 = 女
open class Person(var name: String, var age: Int, var gender: Int): HumenBeing(), AnyThing {

    override var laugh: String = ""

    override fun learn() {
        println("I like learn")
    }

    // 打招呼
    open fun sayHello() {
        var genderString = "man"
        if (gender == 2) {
            genderString = "women"
        }
        Log.i(lmTag, "Hello, I am ${this.name}, I'm $age years old, and I am a kind $genderString")
    }

    override fun sleep() {
        println("I am going to sleep now")
    }

    override fun eat() {
        println("I am going to eat something cause I am hungary")
    }
}