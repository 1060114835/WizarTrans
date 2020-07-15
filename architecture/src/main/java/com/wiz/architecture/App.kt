package com.wiz.architecture

import android.app.Application
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.wiz.architecture.global.Global

open class App : Application(), ViewModelStoreOwner {
    private val viewModelStore = ViewModelStore()

    override fun onCreate() {
        super.onCreate()
        Global.init(this)
    }

    override fun getViewModelStore(): ViewModelStore = viewModelStore
}