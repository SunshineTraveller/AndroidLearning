package com.example.androidlearning.Test

import android.util.Log
import com.example.androidlearning.lmTag

class Boy(name: String, age: Int, height: Float) : Male(name, age, height = height) {
    constructor(name: String, age: Int) : this(name, age,1.2f)
    override fun sayHello() {
        var genderString = "男孩"
        if (gender == 2) {
            genderString = "女孩"
        }
        Log.i(lmTag, "Hello, I am a little boy, my name is ${this.name}, I'm $age years old, and I am a lovely $genderString, I am ${height} meters tall")
    }

    // 重写equal判断两个小男孩是否相同
    override fun equals(other: Any?): Boolean {
        if (other is Boy) {
            return other.name == this.name && other.age == this.age && other.height == this.height
        }

        return super.equals(other)
    }

    override fun toString(): String {
        return "Boy: name = ${this.name}, age = $age, height = $height"
    }
}

