package com.antoshk.android.homework.thread.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.antoshk.android.homework.thread.CounterTask
import com.antoshk.android.homework.thread.CounterTaskStates
import com.antoshk.android.homework.thread.TaskEventListener
import com.antoshk.android.homework.thread.factory.TaskFactory
import java.lang.ref.WeakReference

class ThreadsViewModel(private val taskFactory: TaskFactory) : ViewModel() {
    private val _output: MutableLiveData<String> = MutableLiveData("Threads fragment")
    private var counterTask: CounterTask? = null
    private var state = CounterTaskStates.NOT_CREATED

    val output: LiveData<String> = _output

    private val listener: TaskEventListener = object : TaskEventListener {
        override fun onPreExecute() {
            _output.value = "Task started"
            state = CounterTaskStates.STARTED
        }

        override fun onPostExecute() {
            _output.value = "Done"
            state = CounterTaskStates.FINISHED
        }

        override fun onProgressUpdate(progress: Int) {
            _output.value = progress.toString()
        }
    }

    fun onCreateTask() {
        counterTask = taskFactory.createTask(WeakReference(listener))
        _output.value = "Task created"
        state = CounterTaskStates.CREATED
    }

    fun onStartTask() {
        if (counterTask != null) {
            counterTask!!.start()
        } else {
            _output.value = "Create task before starting!"
        }
    }

    fun onCancelTask() {
        when (state) {
            CounterTaskStates.STARTED -> {
                counterTask?.cancel()
                _output.value = "Task canceled"
                state = CounterTaskStates.FINISHED
            }
            CounterTaskStates.FINISHED -> _output.value = "Task already finished. Create new one"
            CounterTaskStates.CREATED -> _output.value = "Must start task first"
            CounterTaskStates.NOT_CREATED -> _output.value = "Must create task first"
        }
    }

}
