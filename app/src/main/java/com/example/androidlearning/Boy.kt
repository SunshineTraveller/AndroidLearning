package com.example.androidlearning

import android.util.Log
class Boy(name: String, age: Int, height: Float) : Male(name, age, height = height) {
    constructor(name: String, age: Int) : this(name, age,1.2f)
    override fun sayHello() {
        var genderString = "男孩"
        if (gender == 2) {
            genderString = "女孩"
        }
        Log.i(lmTag, "Hello, I am a little boy, my name is ${this.name}, I'm $age years old, and I am a lovely $genderString, I am ${height} meters tall")
    }
}