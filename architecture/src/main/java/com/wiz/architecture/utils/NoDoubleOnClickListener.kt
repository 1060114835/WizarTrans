package com.wiz.architecture.utils

import android.view.View


/**
 * 点击事件防抖
 */
abstract class NoDoubleOnClickListener : View.OnClickListener {

    private var lastExecuteTime = 0L
    private val minimumInterval = 200L

    override fun onClick(v: View?) {
        v?.let {
            if (lastExecuteTime == 0L || System.currentTimeMillis() - lastExecuteTime > minimumInterval) {
                onDoubleOnClick(v)
            }
            lastExecuteTime = System.currentTimeMillis()
        }
    }

    abstract fun onDoubleOnClick(v: View)
}