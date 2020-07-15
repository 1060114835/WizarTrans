package com.wiz.architecture.mvvm

import android.view.View


/**
 * 处理每一个页面的事件
 */
interface ActionHandler {

    fun onClick(viw: View)
}