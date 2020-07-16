package com.wiz.architecture.utils

import android.view.View


/**
 * 点击事件防抖
 */
abstract class NoDoubleOnClickListener : View.OnClickListener {

    private var lastExecuteTime = 0L
    //两次点击之间的最小时间间隔
    private val minimumInterval = 200L

    override fun onClick(v: View?) {
        v?.let {
            if (System.currentTimeMillis() - lastExecuteTime > minimumInterval) {
                lastExecuteTime = System.currentTimeMillis()
                onDoubleOnClick(v)
            }
        }
    }

    abstract fun onDoubleOnClick(v: View)
}