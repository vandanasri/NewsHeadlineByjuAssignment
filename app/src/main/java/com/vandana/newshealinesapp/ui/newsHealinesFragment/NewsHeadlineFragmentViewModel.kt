package com.vandana.newshealinesapp.ui.newsHealinesFragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.vandana.newshealinesapp.data.db.NewsHeadlineEntity
import com.vandana.newshealinesapp.data.model.HeadlinesDataModel
import com.vandana.newshealinesapp.data.repository.FetchNewHeadlinesRepo
import com.vandana.newshealinesapp.di.FragmentScope
import com.vandana.newshealinesapp.ui.base.BaseViewModel
import com.vandana.newshealinesapp.utils.common.Resource
import com.vandana.newshealinesapp.utils.common.Status
import com.vandana.newshealinesapp.utils.network.NetworkHelper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

@FragmentScope
class NewsHeadlineFragmentViewModel(compositeDisposable: CompositeDisposable,
                                    networkHelper: NetworkHelper,
private val fetchNewHeadlinesRepo : FetchNewHeadlinesRepo)
    :BaseViewModel(compositeDisposable,networkHelper) {

    var isLoading : MutableLiveData<Resource<Status>> = MutableLiveData()
    val mNewsHeadlineDataList: MutableLiveData<List<NewsHeadlineEntity>> = MutableLiveData()
    val msgFromDB : MutableLiveData<String> = MutableLiveData()
    val dataCount : MutableLiveData<Int> = MutableLiveData()



    //function to get data from Server
    fun getNewsHeadlinesDataFromServer() {
        if (checkInternetConnection()) {
            isLoading.postValue(Resource.loading())
            compositeDisposable.add(
                fetchNewHeadlinesRepo.fetchNewsHeadLinesDataFromRemote()
                    .subscribeOn(Schedulers.io())
                    .doOnSuccess {

                    insertNewsHeadlineDataIntoDatabase(it.articles)
                    }
                    .subscribe(
                        {
                            isLoading.postValue(Resource.success())
                        },
                        {
                            isLoading.postValue(Resource.error())
                            handleNetworkError(it)

                        })
            )
        } else {

            if(dataCount.value == 0)
                msgFromDB.postValue("There is no cached data available, please check your network connection and try for live data")
            else
                getAllNewsHeadlineDataFromDatabase()
        }
    }



// to insert News Headline Data into DataBase

    private fun insertNewsHeadlineDataIntoDatabase(headlineDataList: List<HeadlinesDataModel.Article>) {

        val entityList = arrayListOf<NewsHeadlineEntity>()

        if(headlineDataList.isNotEmpty()){
        for ((index, newsHeadlineData) in headlineDataList.withIndex()) {
            entityList.add(
                NewsHeadlineEntity(
                    newsHeadlineData.title,
                    newsHeadlineData.urlToImage,
                    newsHeadlineData.description,
                    newsHeadlineData.source?.name,
                    newsHeadlineData.publishedAt
                )
            )
        }
        }

        compositeDisposable.add(
            fetchNewHeadlinesRepo.insertData(entityList)
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        getAllNewsHeadlineDataFromDatabase()
                    },
                    {
                        Log.d("TAG insetDatabase Error", it.toString())
                    }
                )
        )

    } //insertion ends


    //to get all the data from database
    fun getAllNewsHeadlineDataFromDatabase() {
        compositeDisposable.add(
            fetchNewHeadlinesRepo.fetchNewsHeadlineDataFromDatabase()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        Log.v("@ALLDATA", it.size.toString())
                        mNewsHeadlineDataList.postValue(it)
                    },
                    {
                        Log.d("TAG readDatabase Error", it.toString())
                    }
                )
        )
    }


    // to get number of counts of data inserted in db table
    fun getDataCount() {
        //var dataCount = 0
        compositeDisposable.add(
            fetchNewHeadlinesRepo.getNewsHeadlineDataCount()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        Log.v("@Count All", it.toString())
                        //dataCount = it
                        dataCount.postValue(it)

                    },
                    {
                        Log.d("TAG getDataCount Error", it.toString())
                    }
                )
        )

    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    override fun onCreate() {}
}