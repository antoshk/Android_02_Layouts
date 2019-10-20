package com.antoshk.android.homework.thread.factory

import com.antoshk.android.homework.thread.CounterCoroutineTask
import com.antoshk.android.homework.thread.CounterTask
import com.antoshk.android.homework.thread.TaskEventListener
import java.lang.ref.WeakReference
import kotlin.coroutines.CoroutineContext

class CoroutineTaskFactory : TaskFactory{
    override fun createTask(viewRef: WeakReference<TaskEventListener?>, coroutineContext: CoroutineContext, initialCount: Int): CounterTask {
        return CounterCoroutineTask(viewRef, coroutineContext, initialCount)
    }
}