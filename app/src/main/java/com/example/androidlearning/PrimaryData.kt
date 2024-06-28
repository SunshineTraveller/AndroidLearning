package com.example.androidlearning


/*
* 总结
* 1. 末尾为f表示Float数据，L表示Long整形数据，字符串可以直接使用 "+" 拼接基本数据，但是反向不可以
* 2. 嵌套 for 循环 break 和 continue 可以使用 outer@  continue@outer 类似操作来指定到底是 break / continue 哪个 for 循环
* 3. Kotlin 中 ::functionName 表示引用某个 function ，类似 Swift OC 的 #selector
* 4. 日志打印使用系统的 Log ,然后传个tag, d/i/e = debug, info, error, 然后在 Logcat 里查看你要打的日志，并且通过 tag 来筛选
*
* */

class PrimaryData {

    fun primaryDataTest() {
        classTest()
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

    fun classTest() {
        val jessie = Person(name = "Jessie", age = 36, gender = 2)
        jessie.sayHello()
        val john = Male(name = "John", age = 46, height = 1.8f)
        john.sayHello()
        val tom = Boy(name = "Tommy", age = 9)
        tom.sayHello()
        val jack = Boy(name = "Jack", age = 12, height = 1.4f)
        jack.sayHello()
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
//        val array = listOf<String>("A","B","C","D","1","2")
//        array.forEach {
//            Log.i(lmTag, it)
//        }
//        array.forEachIndexed {index,value ->
//            Log.d(lmTag, "index = $index value = $value")
//        }
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