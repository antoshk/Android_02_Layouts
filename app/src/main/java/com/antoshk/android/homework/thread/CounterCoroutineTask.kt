package com.antoshk.android.homework.thread

import kotlinx.coroutines.*
import java.lang.ref.WeakReference
import kotlin.coroutines.CoroutineContext

private const val defaultStartCount = 1

class CounterCoroutineTask(
    private val viewRef: WeakReference<TaskEventListener?>,
    private val initialCount: Int = defaultStartCount
) : CounterTask, CoroutineScope {

    override val coroutineContext: CoroutineContext = SupervisorJob() + Dispatchers.Main
    private lateinit var job: Job

    override fun start() {
        job = launch {
            doJob()
        }
    }

    suspend fun doJob() {
        if (initialCount == defaultStartCount) {
            viewRef.get()?.onPreExecute()
            delay(500L)
        }
        var counter = initialCount
        while (counter < 11) {
            viewRef.get()?.onProgressUpdate(counter)
            counter++
            delay(500L)
        }
        viewRef.get()?.onPostExecute()
    }

    override fun cancel() {
        job.cancel()
        viewRef.get()?.onPostExecute()
    }


}