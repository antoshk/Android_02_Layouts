package com.antoshk.android.homework.thread

import android.view.View
import androidx.fragment.app.Fragment
import java.lang.ref.WeakReference

class JavaThreadsTask(
    private val viewRef: WeakReference<TaskEventListener?>,
    private val initialCount: Int
) : CounterTask {

    private lateinit var workerThread: Thread
    private lateinit var worker: Worker

    override fun start() {
        worker = Worker(viewRef, initialCount)
        workerThread = Thread(worker)
        workerThread.start()
    }

    override fun cancel() {
        worker.isCancelled = true
    }

    class Worker(private val viewRef: WeakReference<TaskEventListener?>, private val initialCount: Int) : Runnable {

        private var view: View? = null
        var isCancelled: Boolean = false

        private fun init() {
            if (viewRef.get() is Fragment) {
                view = (viewRef.get() as Fragment).view
            } else {
                Thread.interrupted()
            }
        }

        private fun runOnUI(work: () -> Unit) {
            view?.post {
                work.invoke()
            }
        }

        override fun run() {

            init()

            if (initialCount == 1) {
                runOnUI {
                    viewRef.get()?.onPreExecute()
                }
                Thread.sleep(500L)
            }
            var counter = initialCount
            while (counter < 11 && !isCancelled) {
                runOnUI {
                    viewRef.get()?.onProgressUpdate(counter)
                }
                Thread.sleep(500L)
                counter++
            }
            if (!isCancelled) {
                runOnUI {
                    viewRef.get()?.onPostExecute()
                }
            }
        }

    }
}