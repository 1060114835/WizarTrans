package com.wiz.architecture.mvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.wiz.architecture.mvvm.viewmodel.StateViewModel
import com.wiz.architecture.App
import com.wiz.architecture.global.state.NetStateManager
import com.wiz.architecture.R
import com.wiz.architecture.mvvm.ActionHandler
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions


/**
 * v层：一个页面只绑定一个StateViewModel和一个ActionHandler，分别处理状态和事件
 */
abstract class BaseActivity : AppCompatActivity(), EasyPermissions.PermissionCallbacks {

    val viewModel by lazy { initViewModel() }
    val actionHandler by lazy { initActionHandler() }

    //activity层面的ViewModelProvider
    val activityViewModelProvider: ViewModelProvider by lazy { ViewModelProvider(this) }

    //application层面的ViewModelProvider
    val appViewModelProvider: ViewModelProvider by lazy {
        ViewModelProvider(application as App, appViewModelFactory) }

    private val appViewModelFactory: ViewModelProvider.AndroidViewModelFactory by lazy {
        ViewModelProvider.AndroidViewModelFactory.getInstance(application as App) }

    protected abstract fun initViewModel() : StateViewModel

    protected abstract fun configureDataBinding() : ViewDataBinding

    protected abstract fun initActionHandler() : ActionHandler

    //页面初始化时加载数据
    protected abstract fun loadData()

    /**
     * 配置权限，子类重写这个方法返回当前页面需要的动态权限
     */
    protected open fun configurePermission() : Array<String>? = null

    /**
     * 配置子类的状态栏，
     */
    protected open fun configureTitleBar() {
        // TODO: 2020/7/14 配置标题栏未完成
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureTitleBar()
        val viewDataBinding = configureDataBinding()
        setContentView(viewDataBinding.root)
        loadData()
        viewDataBinding.lifecycleOwner = this
        lifecycle.addObserver(NetStateManager)
    }

    override fun onResume() {
        super.onResume()
        configurePermission()?.let {
            requestPermissions()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults,this)
    }

    @AfterPermissionGranted(66)
    private fun requestPermissions() {
        val permissions = configurePermission()!!
        if (!EasyPermissions.hasPermissions(this, *permissions)) {
            EasyPermissions.requestPermissions(this,
                resources.getString(R.string.perm_err_info), 66, *permissions)
        }
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        configurePermission()?.let {
            if (EasyPermissions.somePermissionPermanentlyDenied(this, it.toList())) {
                AppSettingsDialog.Builder(this).build().show()
            }
        }
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
    }


}