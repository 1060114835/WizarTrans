package com.wiz.architecture.ext

import android.content.Context
import com.wiz.architecture.utils.LogUtils
import com.wiz.architecture.utils.ToastUtil

fun String.toast() {
    ToastUtil.messageQueue.offer(this)
}

fun String.log() {
    LogUtils.test(this)
}

fun String.log(tag: String) {
    LogUtils.d(tag, this)
}



