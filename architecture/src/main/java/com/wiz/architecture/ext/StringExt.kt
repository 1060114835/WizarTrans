package com.wiz.architecture.ext

import android.content.Context
import com.wiz.architecture.utils.LogUtils
import com.wiz.architecture.utils.ToastUtil

fun String.toast() {
    ToastUtil.messageQueue.add(this)
}

fun String.log(tag: String = "测试") {
    LogUtils.d(tag, this)
}



