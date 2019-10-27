package com.antoshk.android.homework.thread.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.antoshk.android.homework.thread.factory.TaskFactory

class ThreadsViewModelFactory(private val taskFactory: TaskFactory) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass == ThreadsViewModel::class.java) {
            @Suppress("UNCHECKED_CAST")
            ThreadsViewModel(taskFactory) as T
        } else {
            throw IllegalArgumentException("Unknown view model class $modelClass")
        }
    }

}