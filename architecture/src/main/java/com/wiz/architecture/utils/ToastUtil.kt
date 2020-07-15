package com.wiz.architecture.utils

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.Toast
import com.wiz.architecture.ext.log
import java.util.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors

internal object ToastUtil {
    private var lastExecuteTime = 0L
    internal val messageQueue = LinkedList<String>()
    private const val minimumInterval = 1000L
    private val executor: Executor = Executors.newSingleThreadExecutor()
    private const val TOAST_MESSAGE_FLAG = 1

    /**
     *  在application处进行初始化
     */
    fun loop(appContext: Context) {
        val handler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                if (msg.what == TOAST_MESSAGE_FLAG) {
                    Toast.makeText(appContext, msg.obj as String, Toast.LENGTH_SHORT).show()
                }
            }
        }
        executor.execute {
            while (true) {
                if (!messageQueue.isEmpty() &&
                    (lastExecuteTime == 0L ||
                            System.currentTimeMillis() - lastExecuteTime >= minimumInterval)) {
                    val message = Message.obtain().apply {
                        what = TOAST_MESSAGE_FLAG
                        obj = messageQueue.poll()
                        (obj as String).log()
                    }
                    handler.sendMessage(message)
                }
                lastExecuteTime = System.currentTimeMillis()
            }
        }
    }
}