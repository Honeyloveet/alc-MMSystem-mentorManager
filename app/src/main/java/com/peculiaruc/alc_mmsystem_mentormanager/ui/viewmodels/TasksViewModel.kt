package com.peculiaruc.alc_mmsystem_mentormanager.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Task

/**
 * ViewModel for TasksFragment
 */
class TasksViewModel : ViewModel() {

    private val tempTaskDescription = "Task Description"
    private val tempStatusOne = "Assign Task"

    val getTasks = MutableLiveData<MutableList<Task>>()

    private val tasksList = mutableListOf<Task>()

    init {
        fillTempTaskData()
        Log.i("TASKSLIST", getTasks.value.toString())
    }

    private fun fillTempTaskData() {

        val task1 = Task(id = 1, title = "Task One", description = tempTaskDescription, date_created = System.currentTimeMillis(), created_by = 2, status = tempStatusOne,
            program_id = 1
        )
        tasksList.add(task1)

        val task2 = Task(id = 2, title = "Task Two", description = tempTaskDescription, date_created = System.currentTimeMillis(), created_by = 2, status = tempStatusOne,
            program_id = 1
        )
        tasksList.add(task2)

        val task3 = Task(id = 3, title = "Task Three", description = tempTaskDescription, date_created = System.currentTimeMillis(), created_by = 2, status = tempStatusOne,
            program_id = 1
        )
        tasksList.add(task3)

        val task4 = Task(id = 4, title = "Task Four", description = tempTaskDescription, date_created = System.currentTimeMillis(), created_by = 2, status = tempStatusOne,
            program_id = 1
        )
        tasksList.add(task4)

        val task5 = Task(id = 5, title = "Task Five", description = tempTaskDescription, date_created = System.currentTimeMillis(), created_by = 2, status = tempStatusOne,
            program_id = 1
        )
        tasksList.add(task5)

        val task6 = Task(id = 6, title = "Task Six", description = tempTaskDescription, date_created = System.currentTimeMillis(), created_by = 2, status = tempStatusOne,
            program_id = 1
        )
        tasksList.add(task6)

        val task7 = Task(id = 7, title = "Task Seven", description = tempTaskDescription, date_created = System.currentTimeMillis(), created_by = 2, status = tempStatusOne,
            program_id = 1
        )
        tasksList.add(task7)

        val task8 = Task(id = 8, title = "Task Eight", description = tempTaskDescription, date_created = System.currentTimeMillis(), created_by = 2, status = tempStatusOne,
            program_id = 1
        )
        tasksList.add(task8)

        val task9 = Task(id = 9, title = "Task Nine", description = tempTaskDescription, date_created = System.currentTimeMillis(), created_by = 2, status = tempStatusOne,
            program_id = 1
        )
        tasksList.add(task9)

        val task10 = Task(id = 10, title = "Task Ten", description = tempTaskDescription, date_created = System.currentTimeMillis(), created_by = 2, status = tempStatusOne,
            program_id = 1
        )
        tasksList.add(task10)

        getTasks.postValue(tasksList)
    }

}