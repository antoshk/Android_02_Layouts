package com.antoshk.android.homework.thread.factory

import com.antoshk.android.homework.thread.CounterTask
import com.antoshk.android.homework.thread.JavaThreadsTask
import com.antoshk.android.homework.thread.TaskEventListener
import java.lang.ref.WeakReference
import kotlin.coroutines.CoroutineContext

class JavaTreadsTaskFactory : TaskFactory {
    override fun createTask(viewRef: WeakReference<TaskEventListener?>, coroutineContext: CoroutineContext, initialCount: Int): CounterTask {
        return JavaThreadsTask(viewRef, initialCount)
    }
}