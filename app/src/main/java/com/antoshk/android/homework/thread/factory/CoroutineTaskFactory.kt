package com.antoshk.android.homework.thread.factory

import com.antoshk.android.homework.thread.CounterCoroutineTask
import com.antoshk.android.homework.thread.CounterTask
import com.antoshk.android.homework.thread.TaskEventListener
import java.lang.ref.WeakReference

class CoroutineTaskFactory : TaskFactory {
    override fun createTask(viewRef: WeakReference<TaskEventListener?>, initialCount: Int): CounterTask {
        return CounterCoroutineTask(viewRef, initialCount)
    }
}