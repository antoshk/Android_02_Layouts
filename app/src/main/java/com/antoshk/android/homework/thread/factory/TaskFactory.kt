package com.antoshk.android.homework.thread.factory

import com.antoshk.android.homework.thread.CounterTask
import com.antoshk.android.homework.thread.TaskEventListener
import java.io.Serializable
import java.lang.ref.WeakReference

private const val defaultStartCount = 1

interface TaskFactory : Serializable{
    fun createTask(
        viewRef: WeakReference<TaskEventListener?>,
        initialCount: Int = defaultStartCount
    ): CounterTask
}