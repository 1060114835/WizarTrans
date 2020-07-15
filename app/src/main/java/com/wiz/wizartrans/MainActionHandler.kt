package com.wiz.wizartrans

import android.view.View
import com.wiz.architecture.ext.toast
import com.wiz.architecture.mvvm.ActionHandler

class MainActionHandler : ActionHandler {
    override fun onClick(viw: View) {
        "被点击了".toast()
    }

}