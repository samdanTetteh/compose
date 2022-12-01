package com.ijikod.composetutorial.data

fun getWellnessTasks() = List(30) {
    WellnessTask(it, "Task # $it")
}