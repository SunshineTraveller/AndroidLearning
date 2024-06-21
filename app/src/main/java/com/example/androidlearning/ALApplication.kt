package com.example.androidlearning

import android.app.Activity
import android.app.Application
import android.os.Bundle

/*
这里我们自定义一个 Application, 并将此文件绑定到 AndroidManifest 文件中
*/
class ALApplication: Application() {
    public final val TAG = "ALApplication"

    private var activityReferences: Int = 0
    private var isActivityChangingConfigurations: Boolean = false

    // 创建完毕
    override fun onCreate() {
        super.onCreate()
        //... 在这里我们做一些初始化工作
//        setContentView(R.id.activity_main)
        registerApplicationLifeCycle()
    }

    // 即将被销毁
    override fun onTerminate() {
        super.onTerminate()

    }

    /* 应用进入了前台 */
    fun onAppEnterForeground() {

    }

    fun onAppEnterBackground() {

    }

    /* 注册应用状态监听 */
    fun registerApplicationLifeCycle() {
        registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks{
            override fun onActivityCreated(p0: Activity, p1: Bundle?) {

            }

            override fun onActivityResumed(p0: Activity) {
                // do sth here
            }

            override fun onActivityPaused(p0: Activity) {
                // do sth here
            }

            override fun onActivityStarted(p0: Activity) {
                if (++activityReferences == 1 && !isActivityChangingConfigurations) {
                    // App enters foreground
                    onAppEnterForeground()
                }
            }

            override fun onActivityStopped(p0: Activity) {isActivityChangingConfigurations = p0.isChangingConfigurations
                if (--activityReferences == 0 && !isActivityChangingConfigurations) {
                    // App enters background
                    onAppEnterBackground()
                }
            }

            override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
                // do sth here
            }

            override fun onActivityDestroyed(p0: Activity) {
                // do sth here
            }

        })
    }
}
