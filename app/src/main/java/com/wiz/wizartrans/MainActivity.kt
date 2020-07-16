package com.wiz.wizartrans

import androidx.databinding.ViewDataBinding
import com.wiz.architecture.ext.toast
import com.wiz.architecture.mvvm.ActionHandler
import com.wiz.architecture.mvvm.view.BaseActivity
import com.wiz.wizartrans.databinding.MainActivityBinding
import kotlin.concurrent.thread

class MainActivity : BaseActivity() {

    override fun initViewModel() : MainViewModel{
        return activityViewModelProvider[MainViewModel::class.java]
    }

    override fun initActionHandler(): ActionHandler {
        return MainActionHandler()
    }

    override fun loadData() {
        val viewModel = viewModel as MainViewModel
        viewModel.name.set("databing 绑定视图")
    }

    override fun configureDataBinding(): ViewDataBinding {
        val binding = MainActivityBinding.inflate(layoutInflater)
        binding.setVariable(BR.view_model, viewModel)
        binding.setVariable(BR.action_handler, actionHandler)
        return binding
    }




}