package com.learn.growthcodelab.architecture.mvp.tasks

import com.learn.growthcodelab.architecture.data.Task
import com.learn.growthcodelab.architecture.data.TasksFilterType
import com.learn.growthcodelab.architecture.data.source.TasksDataSource
import com.learn.growthcodelab.architecture.data.source.TasksRepository
import com.learn.growthcodelab.argumentCaptor
import com.learn.growthcodelab.capture
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.*

//@RunWith(MockitoJUnitRunner.StrictStubs::class)
class TasksPresenterTest {

    companion object {
        val TASKS = mutableListOf<Task>()
    }

    @Mock
    private lateinit var view: TasksContract.View

    @Mock
    private lateinit var repository: TasksRepository

    @Captor
    private lateinit var loadAllTasksCallbackCaptor: ArgumentCaptor<TasksDataSource.LoadAllTasksCallback>

    private lateinit var presenter: TasksPresenter

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this);

        presenter = TasksPresenter(repository, view)

        Mockito.`when`(view.isActive()).thenReturn(true)

        TASKS.clear()
        TASKS.add(Task("Title1", "Description1"))
        TASKS.add(Task("Title2", "Description2").apply { isCompleted = true })
        TASKS.add(Task("Title3", "Description3").apply { isCompleted = true })
    }

    @Test
    fun test_create_presenter() {
        presenter = TasksPresenter(repository, view)

        Mockito.verify(view).setPresenter(presenter)
    }

    @Test
    fun test_show_all_tasks() {
        with(presenter) {
            currentFilterType = TasksFilterType.ALL_TASKS
            loadTasks(true)
        }

        Mockito.verify(repository).loadAllTasks(capture(loadAllTasksCallbackCaptor))
        loadAllTasksCallbackCaptor.value.onAllTasksLoaded(TASKS)

        val inorder = Mockito.inOrder(view)
        inorder.verify(view).showLoadingIndicator(true)
        inorder.verify(view).showLoadingIndicator(false)

        val tasksCaptor = argumentCaptor<List<Task>>()
        Mockito.verify(view).showTasks(capture(tasksCaptor))
        Assert.assertTrue(tasksCaptor.value.size == 3)
    }

    @Test
    fun test_show_active_tasks() {
        with(presenter) {
            currentFilterType = TasksFilterType.ACTIVE_TASKS
            loadTasks(true)
        }

        Mockito.verify(repository).loadAllTasks(capture(loadAllTasksCallbackCaptor))
        loadAllTasksCallbackCaptor.value.onAllTasksLoaded(TASKS)
        Mockito.verify(view).showLoadingIndicator(false)

        val tasksCaptor = argumentCaptor<List<Task>>()
        Mockito.verify(view).showTasks(capture(tasksCaptor))
        Assert.assertTrue(tasksCaptor.value.size == 1)
    }

    @Test
    fun test_show_completed_tasks() {
        with(presenter) {
            currentFilterType = TasksFilterType.COMPLETED_TASKS
            loadTasks(true)
        }

        Mockito.verify(repository).loadAllTasks(capture(loadAllTasksCallbackCaptor))
        loadAllTasksCallbackCaptor.value.onAllTasksLoaded(TASKS)
        Mockito.verify(view).showLoadingIndicator(false)

        val tasksCaptor = argumentCaptor<List<Task>>()
        Mockito.verify(view).showTasks(capture(tasksCaptor))
        Assert.assertTrue(tasksCaptor.value.size == 2)

    }


}