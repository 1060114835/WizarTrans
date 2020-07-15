package com.wiz.architecture.utils

import android.util.Log
import com.wiz.architecture.BuildConfig

internal object LogUtils {

    fun test(message: String) {
        if (BuildConfig.DEBUG) Log.d("测试", message)
    }
    fun d(tag: String, message: String) {
        if (BuildConfig.DEBUG) Log.d(tag, message)
    }
    fun e(tag: String, message: String) {
        if (BuildConfig.DEBUG) Log.e(tag, message)
    }
    fun i(tag: String, message: String) {
        if (BuildConfig.DEBUG) Log.i(tag, message)
    }
    fun v(tag: String, message: String) {
        if (BuildConfig.DEBUG) Log.v(tag, message)
    }
    fun w(tag: String, message: String) {
        if (BuildConfig.DEBUG) Log.w(tag, message)
    }




}