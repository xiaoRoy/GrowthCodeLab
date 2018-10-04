package com.learn.growthcodelab.architecture.mvp.tasks

import com.learn.growthcodelab.architecture.mvp.data.source.TasksDataSource
import com.learn.growthcodelab.architecture.mvp.data.source.TasksRepository
import org.junit.Before
import org.junit.Test
import org.mockito.*

//@RunWith(MockitoJUnitRunner.StrictStubs::class)
class TasksPresenterTest {

    @Mock
    private lateinit var view: TasksContract.View

    @Mock
    private lateinit var repository: TasksRepository

    @Captor
    private lateinit var loadAllTasksCallbackCaptor: ArgumentCaptor<TasksDataSource.LoadAllTasksCallback>

    private lateinit var presenter: TasksPresenter

    @Before fun setup(){
        MockitoAnnotations.initMocks(this);

        presenter = TasksPresenter(repository, view)

        Mockito.`when`(view.isActive()).thenReturn(true)
    }

    @Test
    fun test_create_presenter(){
        presenter = TasksPresenter(repository, view)

        Mockito.verify(view).setPresenter(presenter)
    }


}