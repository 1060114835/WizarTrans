package com.wiz.architecture.binding_adapter

import android.media.Image
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.wiz.architecture.mvvm.ActionHandler
import com.wiz.architecture.utils.NoDoubleOnClickListener

/**
 * 全局通用BindingAdapter绑定
 */

class BindingAdapter {
    @BindingAdapter("app:src")
    fun src(imageView: ImageView, url: String) {
        Glide.with(imageView.context).load(url).into(imageView)
    }

    @BindingAdapter("app:onClick")
    fun onClick(view: View, actionHandler: ActionHandler) {
        view.setOnClickListener(object : NoDoubleOnClickListener() {
            override fun onDoubleOnClick(v: View) {
                actionHandler.onClick(v)
            }
        })
    }


}