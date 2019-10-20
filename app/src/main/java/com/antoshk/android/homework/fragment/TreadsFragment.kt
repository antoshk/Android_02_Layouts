package com.antoshk.android.homework.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.antoshk.android.R
import com.antoshk.android.homework.FragmentLoader
import com.antoshk.android.homework.thread.CounterTask
import com.antoshk.android.homework.thread.CounterTaskStates
import com.antoshk.android.homework.thread.TaskEventListener
import com.antoshk.android.homework.thread.factory.TaskFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import java.lang.ref.WeakReference

const val ARG_COUNTER_STATE = "ARG_COUNTER_STATE"
const val ARG_STATE = "ARG_STATE"

class TreadsFragment : Fragment(), CoroutineScope, TaskEventListener {

    override val coroutineContext = SupervisorJob() + Dispatchers.Main
    private var fragmentLoader: FragmentLoader? = null
    private var counterTask: CounterTask? = null
    private var state = CounterTaskStates.NOT_CREATED
    private var taskFactory: TaskFactory? = null

    companion object {
        private const val TASK_FACTORY = "TASK_FACTORY"

        fun newInstance(taskFactory: TaskFactory): TreadsFragment {
            val fragment = TreadsFragment()
            val bundle = Bundle()
            bundle.putSerializable(TASK_FACTORY, taskFactory)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.activity_threads, container, false)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentLoader) {
            fragmentLoader = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        fragmentLoader = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        taskFactory = arguments?.getSerializable(TASK_FACTORY) as TaskFactory?
        val output: TextView = view.findViewById(R.id.threads_output)
        output.text = "Coroutines fragment"
        view.findViewById<Button>(R.id.create_thread_button).setOnClickListener {
            counterTask = taskFactory?.createTask(WeakReference(this), coroutineContext)
            output.text = "Task created"
            state = CounterTaskStates.CREATED
        }
        view.findViewById<Button>(R.id.start_thread_button).setOnClickListener {
            counterTask?.start()
        }
        view.findViewById<Button>(R.id.cancel_thread_button).setOnClickListener {
            counterTask?.cancel()
            output.text = "Task canceled"
            state = CounterTaskStates.FINISHED
        }

        restoreState(savedInstanceState)

    }

    private fun restoreState(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {

            val savedState = (savedInstanceState.getSerializable(ARG_STATE) ?: CounterTaskStates.NOT_CREATED) as CounterTaskStates
            val savedValue: String? = savedInstanceState.getString(ARG_COUNTER_STATE)

            when (savedState) {
                CounterTaskStates.STARTED -> {
                    savedValue?.toIntOrNull()?.let { initValue: Int ->
                        counterTask = taskFactory?.createTask(WeakReference(this), coroutineContext, initValue)
                        counterTask?.start()
                    }
                }
                CounterTaskStates.CREATED -> {
                    counterTask = taskFactory?.createTask(WeakReference(this), coroutineContext)
                    updateText(savedValue)
                }
                else -> updateText(savedValue)
            }

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        view?.findViewById<TextView>(R.id.threads_output).run {
            outState.putString(ARG_COUNTER_STATE, this?.text.toString())
        }
        outState.putSerializable(ARG_STATE, state)
        super.onSaveInstanceState(outState)
    }

    override fun onPreExecute() {
        updateText("Task started")
        state = CounterTaskStates.STARTED
    }

    override fun onPostExecute() {
        updateText("Done")
        state = CounterTaskStates.FINISHED
    }

    override fun onProgressUpdate(progress: Int) {
        updateText(progress.toString())
    }

    private fun updateText(text: String?) {
        view?.findViewById<TextView>(R.id.threads_output).run {
            this?.text = text
        }
    }
}