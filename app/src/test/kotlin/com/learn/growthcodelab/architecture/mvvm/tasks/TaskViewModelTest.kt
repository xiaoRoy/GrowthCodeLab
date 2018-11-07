package com.learn.growthcodelab.architecture.mvvm.tasks

import android.content.Context
import android.content.res.Resources
import com.learn.growthcodelab.architecture.data.Task
import com.learn.growthcodelab.architecture.data.source.TasksDataSource
import com.learn.growthcodelab.architecture.data.source.TasksRepository
import org.junit.Before
import org.mockito.ArgumentCaptor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class TaskViewModelTest {

    private companion object {
        val TASKS = mutableListOf<Task>()
    }

    @Mock
    private lateinit var context: Context

    @Mock
    private lateinit var tasksRepository: TasksRepository

    @Mock
    private lateinit var loadAllTasksCallbackCaptor: ArgumentCaptor<TasksDataSource.LoadAllTasksCallback>


    private lateinit var taskViewModel: TaskViewModel


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        setupContext()
        TASKS.clear()
        TASKS.add(Task("Title1", "Description1"))
        val taskB = Task("Title2", "Description2")
        taskB.isCompleted = true
        TASKS.add(taskB)
        val taskC = Task("Title3", "Description3")
        taskC.isCompleted = true
        TASKS.add(taskC)
        taskViewModel = TaskViewModel(tasksRepository, context)
    }

    private fun setupContext() {
        Mockito.`when`(context.applicationContext).thenReturn(context)
        Mockito.`when`(context.resources).thenReturn(Mockito.mock(Resources::class.java))
    }
}