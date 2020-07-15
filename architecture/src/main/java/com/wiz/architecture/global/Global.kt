package com.wiz.architecture.global

import android.app.Application
import com.wiz.architecture.utils.ToastUtil

object Global {
    private lateinit var _application: Application

    val application get() = _application

    val GLOBAL_CONFIG = HashMap<String, Any>()

    fun init(appContext: Application) {
        ToastUtil.loop(appContext)
        _application = appContext
    }

}


