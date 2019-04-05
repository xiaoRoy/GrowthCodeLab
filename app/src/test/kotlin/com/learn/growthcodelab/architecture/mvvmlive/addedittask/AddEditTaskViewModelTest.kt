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

    private lateinit var addEditTaskViewModel: AddEditTaskViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        addEditTaskViewModel = AddEditTaskViewModel(taskRepository)
    }

    @Test
    fun test_viewTask() {
        val task = Task("description", "title", id = "44")
        addEditTaskViewModel = AddEditTaskViewModel(taskRepository)
        addEditTaskViewModel.start(taskId = task.id)
        Mockito.verify(taskRepository).loadSingleTask(eq("44"), capture(loadSingleTaskCaptor))
        loadSingleTaskCaptor.value.onSingleTaskLoaded(task)
        Assert.assertThat(getValue(addEditTaskViewModel.title), Matchers.`is`("title"))
        Assert.assertThat(getValue(addEditTaskViewModel.description), Matchers.`is`("description"))
    }

}