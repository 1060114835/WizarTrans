package com.wiz.wizartrans

import android.view.View
import android.widget.Toast
import com.wiz.architecture.ext.toast
import com.wiz.architecture.mvvm.ActionHandler

class SampleFragActionHandler : ActionHandler {

    override fun onClick(viw: View) {
        "被电击了".toast()
    }

}