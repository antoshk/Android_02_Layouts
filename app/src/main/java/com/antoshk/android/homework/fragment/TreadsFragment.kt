package com.antoshk.android.homework.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.antoshk.android.R
import com.antoshk.android.homework.FragmentLoader
import com.antoshk.android.homework.thread.factory.TaskFactory
import com.antoshk.android.homework.thread.model.ThreadsViewModel
import com.antoshk.android.homework.thread.model.ThreadsViewModelFactory

class TreadsFragment : Fragment(), Observer<String> {

    private var fragmentLoader: FragmentLoader? = null
    private var taskFactory: TaskFactory? = null
    lateinit var viewModel: ThreadsViewModel

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

    override fun onChanged(t: String?) {
        updateText(t)
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
        if (taskFactory != null) {
            viewModel = ViewModelProviders.of(this, ThreadsViewModelFactory(taskFactory!!)).get(ThreadsViewModel::class.java)
            viewModel.exposedLiveDataText.observe(this, this)

            view.findViewById<Button>(R.id.create_thread_button).setOnClickListener {
                viewModel.onCreateTask()
            }
            view.findViewById<Button>(R.id.start_thread_button).setOnClickListener {
                viewModel.onStartTask()
            }
            view.findViewById<Button>(R.id.cancel_thread_button).setOnClickListener {
                viewModel.onCancelTask()
            }
        }

    }

    private fun updateText(text: String?) {
        view?.findViewById<TextView>(R.id.threads_output).run {
            this?.text = text
        }
    }
}