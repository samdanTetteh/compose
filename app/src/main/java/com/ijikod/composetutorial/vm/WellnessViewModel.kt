package com.ijikod.composetutorial.vm

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.ijikod.composetutorial.data.WellnessTask

class WellnessViewModel(): ViewModel() {

    private val _tasks = getWellnessTasks().toMutableStateList()

    val tasks : List<WellnessTask>
        get() = _tasks

    fun removeTask(item: WellnessTask){
        _tasks.remove(item)
    }
}

private fun getWellnessTasks() = List(30) {
    WellnessTask(it, "Task # $it")
}