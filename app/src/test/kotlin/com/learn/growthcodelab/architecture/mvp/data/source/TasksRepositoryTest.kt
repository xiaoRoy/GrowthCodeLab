package com.learn.growthcodelab.architecture.mvp.data.source

import com.learn.growthcodelab.any
import com.learn.growthcodelab.architecture.mvp.data.Task
import com.learn.growthcodelab.architecture.mvp.data.source.local.TasksLocalDataSource
import com.learn.growthcodelab.architecture.mvp.data.source.remote.TasksRemoteDataSource
import com.learn.growthcodelab.capture
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.StrictStubs::class)
class TasksRepositoryTest {

    private companion object {
        const val TASK_TITLE_A = "top good"
        const val TASK_TITLE_B = "top good a"
        const val TASK_TITLE_C = "top good b"
        const val TASK_DESCRIPTION = "description"
        val TASKS = listOf(Task(TASK_TITLE_A, TASK_DESCRIPTION),
                Task(TASK_TITLE_B, TASK_DESCRIPTION))
    }

    private lateinit var tasksRepository: TasksRepository

    @Mock
    private lateinit var tasksLocalDataSource: TasksLocalDataSource

    @Mock
    private lateinit var tasksRemoteDataSource: TasksRemoteDataSource

    @Mock
    private lateinit var loadAllTasksCallback: TasksDataSource.LoadAllTasksCallback

    @Captor
    private lateinit var loadAllTasksCallbackCaptor: ArgumentCaptor<TasksDataSource.LoadAllTasksCallback>

    @Before
    fun setup() {
        tasksRepository = TasksRepository.getInstance(tasksLocalDataSource, tasksRemoteDataSource)
    }

    @After
    fun cleanUp() {
        TasksRepository.destroyInstance()
    }

    private fun twoTasksLoadCallToRepository(loadAllTasksCallback: TasksDataSource.LoadAllTasksCallback) {
        tasksRepository.loadAllTasks(loadAllTasksCallback)

        verify(tasksLocalDataSource).loadAllTasks(capture(loadAllTasksCallbackCaptor))
        loadAllTasksCallbackCaptor.value.onAllTasksNotAvailable()

        verify(tasksRemoteDataSource).loadAllTasks(capture(loadAllTasksCallbackCaptor))
        loadAllTasksCallbackCaptor.value.onAllTasksLoaded(TASKS)

        tasksRepository.loadAllTasks(loadAllTasksCallback)
    }

    @Test
    fun test_load_all_tasks_cache_after_first_api_call(){
        twoTasksLoadCallToRepository(loadAllTasksCallback)

        //only called one time
        verify(tasksRemoteDataSource).loadAllTasks(any())
    }


}