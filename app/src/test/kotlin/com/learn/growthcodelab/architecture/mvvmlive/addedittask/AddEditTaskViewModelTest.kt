package com.learn.growthcodelab.architecture.mvvmlive.addedittask

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.learn.growthcodelab.architecture.data.Task
import com.learn.growthcodelab.architecture.data.source.TasksDataSource
import com.learn.growthcodelab.architecture.data.source.TasksRepository
import com.learn.growthcodelab.architecture.getValue
import com.learn.growthcodelab.capture
import com.learn.growthcodelab.eq
import org.hamcrest.Matchers
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.*

class AddEditTaskViewModelTest {

    @get:Rule var instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var taskRepository: TasksRepository

    @Captor
    private lateinit var loadSingleTaskCaptor: ArgumentCaptor<TasksDataSource.LoadSingleTaskCallback>

    @Captor
    private lateinit var savedTaskCaptor: ArgumentCaptor<Task>

    private lateinit var addEditTaskViewModel: AddEditTaskViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        addEditTaskViewModel = AddEditTaskViewModel(taskRepository)
    }

    @Test
    fun test_viewTask() {
        val task = Task("description", "title", id = "44")
        addEditTaskViewModel.start(taskId = task.id)
        Mockito.verify(taskRepository).loadSingleTask(eq("44"), capture(loadSingleTaskCaptor))
        loadSingleTaskCaptor.value.onSingleTaskLoaded(task)
        Assert.assertThat(getValue(addEditTaskViewModel.title), Matchers.`is`("title"))
        Assert.assertThat(getValue(addEditTaskViewModel.description), Matchers.`is`("description"))
    }

    @Test
    fun test_addTask_showSuccessMessage() {
        with(addEditTaskViewModel) {
            description.value = "new description"
            title.value = "new title"
            saveTask()
        }
        Mockito.verify(taskRepository).saveTask(capture(savedTaskCaptor))
        Assert.assertThat(savedTaskCaptor.value.title, Matchers.`is`("new title"))
        Assert.assertThat(savedTaskCaptor.value.description, Matchers.`is`("new description"))
    }

}