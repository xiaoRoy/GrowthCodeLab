package com.learn.growthcodelab.architecture.mvvm.addedittask

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.learn.growthcodelab.architecture.data.source.TasksDataSource
import com.learn.growthcodelab.architecture.data.source.TasksRepository
import com.learn.growthcodelab.architecture.data.source.TasksRepositoryTest
import com.learn.growthcodelab.architecture.mvvmlive.addedittask.AddEditTaskViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class AddEditTaskViewModelTest {

    @get:Rule var instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var taskRepository: TasksRepository

    @Mock
    private lateinit var loadSingleTaskCaptor: ArgumentCaptor<TasksDataSource.LoadSingleTaskCallback>

    private lateinit var addEditTaskViewModel: AddEditTaskViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        addEditTaskViewModel = AddEditTaskViewModel(taskRepository)
    }

    @Test
    fun test_viewTask() {

    }

}