package com.example.androidlearning.Test

import android.util.Log
import com.example.androidlearning.lmTag

/*
项目知识点汇总:
1、去掉顶部标题栏的方法：
在 AndroidManifest.xml 文件汇总找到 theme 条目，将其改成 android:theme="@style/Theme.AppCompat.Light.NoActionBar" 即可。

2、ImageView 的填充模式用 scaleType 属性控制。以下是一些常用的 scaleType 选项及其效果：
   center：保持原始大小，图片位于视图的中心。如果图片比视图大，则会裁剪图片。
   centerCrop：缩放图片使其至少一边与视图大小匹配，并且保持图片的纵横比。超出的部分会被裁剪。
   centerInside：缩放图片使其完全显示在视图内，并且保持图片的纵横比。如果图片比视图小，则居中显示。
   fitCenter：缩放图片使其完全显示在视图内，并且保持图片的纵横比，居中显示。
   fitStart：缩放图片使其完全显示在视图内，并且保持图片的纵横比，顶部对齐。
   fitEnd：缩放图片使其完全显示在视图内，并且保持图片的纵横比，底部对齐。
   fitXY：缩放图片以适应视图的大小，不保持图片的纵横比。
   matrix：使用矩阵来绘制图片，可以进行任意的缩放、平移、旋转等变换。

3、android:id="@+id/k_title_bar_username_contaienr" ，id 命名中，+id 才是命名，没有 + 号则为引用某个id
4、使用 CardView 做圆角时，如果想让目标颜色带透明度，不能设置 cardview 的background，而是要设置 cardview 的 cardBackgroundColor 就OK了。
5、TextView 中，android:gravity="center_vertical|right" 文本内容居中后可以通过 |left/right 来靠左或靠右对齐








* */

/*
* 总结
* 1. 末尾为f表示Float数据，L表示Long整形数据，字符串可以直接使用 "+" 拼接基本数据，但是反向不可以
* 2. 嵌套 for 循环 break 和 continue 可以使用 outer@  continue@outer 类似操作来指定到底是 break / continue 哪个 for 循环
* 3. Kotlin 中 ::functionName 表示引用某个 function ，类似 Swift OC 的 #selector
* 4. 日志打印使用系统的 Log ,然后传个tag, d/i/e = debug, info, error, 然后在 Logcat 里查看你要打的日志，并且通过 tag 来筛选
*
* */

class KotlinLearn {

    fun primaryDataTest() {
//        classTest()
//        Log.i(lmTag,switchTest(2f))
//        Log.i(lmTag,switchTest(2.345))
//        Log.i(lmTag,switchTest(listOf<String>("ABCDEFG")))
//        Log.i(lmTag,switchTest(::arrayTest))
//        Log.i(lmTag,switchTest(1))

//        arrayTest()
//        boolenTest()
//        intLongTest()
//        floatDoubleTest()
//        stringTest()
//        forMethodTest()
//        println(sum(2, 5))
    }

/*
泛型的使用
* */
    fun <A, B, C> fanxingFunc(p1: A, p2: B, p3: C) {

    }


    /*
    * 扩展函数
    * fun Class.testFunction() {}
    * */
    private fun Boy.testLaugh(str: String) {
        Log.i(lmTag,"哈哈哈 笑死我了, 我叫 ${this.name}")
    }

    fun test(boy: Boy?): Boy? = boy?.apply {

    }

    fun classTest() {

        // 这里也是一个函数的扩展，但是没有函数名，只有函数的参数
        var funVariable: Boy.(String, Int) -> Unit = { str, intValue ->
            Log.i(lmTag, "emmmmm, 你传的是 $str 和 数字 $intValue")
        }
        val jessie = Person(name = "Jessie", age = 36, gender = 2)
        jessie.sayHello()
        val john = Male(name = "John", age = 46, height = 1.8f)
        john.sayHello()
        val tom = Boy(name = "Tommy", age = 9)
        tom.sayHello()
        val jack = Boy(name = "Jack", age = 12, height = 1.4f)
        jack.sayHello()
        jack.testLaugh(str = "asda")
        jack.funVariable("What the fuxx?", 5)
        jack.apply {
            println(jack.name)
        }
    }

    fun switchTest(param: Any = UInt): String {
        when(param) {
            is Function<*> -> {
                return "这是一个 函数 function 数据, 值为 $param"
            }
            is List<*> -> return "这是一个 list<*> 数据, 值为 $param"
            is String -> return "这是一个 String 数据, 值为 $param"
            is Int -> return "这是一个 Int 数据, 值为 $param"
            is Double -> return "这是一个 Double 数据, 值为 $param"
        }
        return "未知类型数据 $param"
    }

    fun arrayTest() {
        val array = listOf<String>("A","B","C","D","1","2")

        // 纯元素遍历
        array.forEach {
            Log.i(lmTag, it)
        }

        // 带索引和元素的遍历
        array.forEachIndexed {index,value ->
            Log.d(lmTag, "index = $index value = $value")
        }

        // 带索引的遍历
        array.indices.forEach { index ->
            Log.i(lmTag, "当前是 $index")
        }

        for ((index, item) in array.withIndex()) {
            Log.i(lmTag, "元素 = $item, 索引 = $index")
        }

        Log.i(lmTag, array.joinToString())
    }

    fun sum(a: Int, b: Int): Double {
        return (a + b).toDouble()
    }

    fun sum(a: Int, b: Int, c: Float = 0f): Double {
        println(c)
        return (a + b).toDouble()
    }

    fun boolenTest() {
        val isEarthBiggerThanMoon = true
        var isTodayIsHoliday = true
        println("Is earth bigger than moon? The answer is ${isEarthBiggerThanMoon}")
        println("Is today is Holiday? The answer is $isTodayIsHoliday")
        isTodayIsHoliday = false
        println("No, today is not holiday, !${isTodayIsHoliday}")
    }

    fun intLongTest() {
        val aInt = 23334
        val aLong = 23434454L
        if (aInt == 233 || aInt.equals(2345)) {
            println(aInt)
        }
        println("The int value is $aInt, the long value is ${aLong}")
    }

    fun floatDoubleTest() {
        val aFlout: Float = 234.3435f
        val aDouble: Double = 34234.2342433
        println("The float value is $aFlout, the double value is $aDouble")
    }

    fun stringTest() {
        val doubleValue: Double = 232.34343
        val aString: String = "asdasd"
        val bString: String = aString + doubleValue
        println("The aString is $aString, the bString is $bString")
    }

    fun forMethodTest() {
        val range = 1 .. 200
        for (i in range) {
            for (j in 201 .. 300) {
                println("i = $i, j = $j")
            }
        }

        outerFor@for (a in 1 ..10) {
            innerFor@for (b in 20 .. 30) {
                if (a == 5 && b < 25) {
                    continue@innerFor
                }
                if (a == 10 && b < 28) {
                    continue@outerFor
                }
                println("i = $a, j = $b")
            }
        }

    }

}