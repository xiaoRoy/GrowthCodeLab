package com.learn.growthcodelab.architecture.mvp.data.source

import com.learn.growthcodelab.any
import com.learn.growthcodelab.architecture.data.Task
import com.learn.growthcodelab.architecture.data.source.TasksDataSource
import com.learn.growthcodelab.architecture.data.source.TasksRepository
import com.learn.growthcodelab.architecture.data.source.local.TasksLocalDataSource
import com.learn.growthcodelab.architecture.data.source.remote.TasksRemoteDataSource
import com.learn.growthcodelab.capture
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.Mockito.*
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

    private fun setTaskAvailable(tasksDataSource: TasksDataSource, tasks: List<Task>) {
        verify(tasksDataSource).loadAllTasks(capture(loadAllTasksCallbackCaptor))
        loadAllTasksCallbackCaptor.value.onAllTasksLoaded(tasks)
    }

    private fun setTaskNotAvailable(tasksDataSource: TasksDataSource) {
        verify(tasksDataSource).loadAllTasks(capture(loadAllTasksCallbackCaptor))
        loadAllTasksCallbackCaptor.value.onAllTasksNotAvailable()
    }

    @Test
    fun test_load_all_tasks_cache_after_first_api_call() {
        twoTasksLoadCallToRepository(loadAllTasksCallback)

        //only called one time
        verify(tasksRemoteDataSource).loadAllTasks(any())
    }

    @Test
    fun test_load_all_tasks_from_local() {
        tasksRepository.loadAllTasks(loadAllTasksCallback)

        verify(tasksLocalDataSource).loadAllTasks(any())
    }

    @Test
    fun test_load_all_tasks_with_dirty_cache_from_remote() {
        tasksRepository.refreshTasks()
        tasksRepository.loadAllTasks(loadAllTasksCallback)

        setTaskAvailable(tasksRemoteDataSource, TASKS)
        verify(tasksLocalDataSource, never()).loadAllTasks(loadAllTasksCallback)
        verify(loadAllTasksCallback).onAllTasksLoaded(TASKS)
    }

    @Test
    fun test_load_all_tasks_with_local_data_not_available_from_remote() {
        tasksRepository.loadAllTasks(loadAllTasksCallback)

        setTaskNotAvailable(tasksLocalDataSource)
        setTaskAvailable(tasksRemoteDataSource, TASKS)

        verify(loadAllTasksCallback).onAllTasksLoaded(TASKS)
    }

    @Test
    fun test_load_all_tasks_both_data_source_not_available() {
        tasksRepository.loadAllTasks(loadAllTasksCallback)

        setTaskNotAvailable(tasksLocalDataSource)
        setTaskNotAvailable(tasksRemoteDataSource)

        verify(loadAllTasksCallback).onAllTasksNotAvailable()
    }

    @Test
    fun test_load_all_tasks_refresh_local_data_source() {
        tasksRepository.refreshTasks()
        tasksRepository.loadAllTasks(loadAllTasksCallback)

        setTaskAvailable(tasksRemoteDataSource, TASKS)
        verify(tasksLocalDataSource, times(TASKS.size)).saveTask(any())
    }




}