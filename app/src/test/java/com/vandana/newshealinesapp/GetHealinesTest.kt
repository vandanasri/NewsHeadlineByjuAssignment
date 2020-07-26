package com.vandana.newshealinesapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.vandana.newshealinesapp.data.model.HeadlinesDataModel
import com.vandana.newshealinesapp.data.remote.NetworkService
import com.vandana.newshealinesapp.data.repository.FetchNewHeadlinesRepo
import com.vandana.newshealinesapp.rx.TestSchedulerProvider
import com.vandana.newshealinesapp.ui.newsHealinesFragment.NewsHeadlineFragmentViewModel
import com.vandana.newshealinesapp.utils.common.Resource
import com.vandana.newshealinesapp.utils.common.Status
import com.vandana.newshealinesapp.utils.network.NetworkHelper
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.TestScheduler
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.doThrow
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetHealinesTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var networkHelper: NetworkHelper

    @Mock
    private  lateinit var fetchNewHeadlinesRepo: FetchNewHeadlinesRepo

    @Mock
    private lateinit var isLoadingObserver: Observer<Resource<Status>>

    @Mock
    private lateinit var messageStringIdObserver: Observer<Resource<Int>>

    private lateinit var testScheduler: TestScheduler

    private lateinit var fragViewModel: NewsHeadlineFragmentViewModel



    @Before
    fun setUp() {
        val compositeDisposable = CompositeDisposable()
        testScheduler = TestScheduler()
        val testSchedulerProvider = TestSchedulerProvider(testScheduler)

        fragViewModel = NewsHeadlineFragmentViewModel(
            testSchedulerProvider,
            compositeDisposable,
            networkHelper,
            fetchNewHeadlinesRepo
        )

        fragViewModel.isLoading.observeForever(isLoadingObserver)
        fragViewModel.messageStringId.observeForever(messageStringIdObserver)

    }


    @Test
    fun givenServerResponse200_whenNewsApiCall(){
       // networkService.getTopHeadlines("in","cba1dd094e454dc8b4f400f1d839ecb6")

        val articleResponse1 = HeadlinesDataModel.Article(
            HeadlinesDataModel.Source(0, "CNN"),"Author1", "Title1",
            "description1","url1","urlImage1","20/1/20","content1")

        val articleResponse2 = HeadlinesDataModel.Article(
            HeadlinesDataModel.Source(0, "CNN2"),"Author2", "Title2",
            "description2","url2","urlImage2","20/2/20","content2")

        val response = HeadlinesDataModel(
            "ok",
            38,
            listOf(articleResponse1,articleResponse2))


        Mockito.doReturn(true)
            .`when`(networkHelper)
            .isNetworkConnected()
        Mockito.doReturn(Single.just(response))
            .`when`(fetchNewHeadlinesRepo)
            .fetchNewsHeadLinesDataFromRemote()
        fragViewModel.getNewsHeadlinesDataFromServer()

        testScheduler.triggerActions()

        Mockito.verify(isLoadingObserver).onChanged(Resource.loading())
        Mockito.verify(isLoadingObserver).onChanged(Resource.success())
       // Mockito.verify(isLoadingObserver).onChanged(Resource.error())


//        `when`(networkHelper.isNetworkConnected()).thenReturn(true)
//        `when`(networkHelper.isNetworkConnected()).thenThrow(NullPointerException.class)
//        doThrow(NullPointerException.class).`when`(networkHelper).isNetworkConnected()
    }



    @After
    fun tearDown(){
        fragViewModel.isLoading.removeObserver(isLoadingObserver)
        fragViewModel.messageStringId.removeObserver(messageStringIdObserver)
    }

}