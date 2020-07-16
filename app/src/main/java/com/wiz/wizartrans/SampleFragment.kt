package com.wiz.wizartrans

import androidx.databinding.ViewDataBinding
import com.wiz.architecture.mvvm.ActionHandler
import com.wiz.architecture.mvvm.view.BaseFragment
import com.wiz.architecture.mvvm.viewmodel.StateViewModel
import com.wiz.wizartrans.databinding.SampleFragmentBinding

class SampleFragment : BaseFragment() {
    lateinit var binding: SampleFragmentBinding

    override fun initViewModel() = fragmentViewModelProvider[SampleFragViewModel::class.java]

    override fun configureVariable() {
        binding = viewDataBinding as SampleFragmentBinding
        binding.setVariable(BR.view_model, viewModel)
        binding.setVariable(BR.action_handler, actionHandler)
    }

    override fun configureLayoutId() = R.layout.sample_fragment

    override fun initActionHandler() = SampleFragActionHandler()
    override fun loadData() {
        val viewModel = viewModel as SampleFragViewModel
        viewModel.name.set("databinding绑定数据")
    }

}