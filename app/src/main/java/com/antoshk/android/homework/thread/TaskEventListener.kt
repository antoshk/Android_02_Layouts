package com.antoshk.android.homework.thread

interface TaskEventListener {

    fun onPreExecute()
    fun onPostExecute()
    fun onProgressUpdate(progress: Int)
}