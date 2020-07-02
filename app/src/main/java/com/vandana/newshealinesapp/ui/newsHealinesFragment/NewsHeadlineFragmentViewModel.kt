package com.vandana.newshealinesapp.ui.newsHealinesFragment

import androidx.lifecycle.MutableLiveData
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



    //function to get data from Server
    fun getNewsHeadlinesData() {
        if (checkInternetConnection()) {
            isLoading.postValue(Resource.loading())
            compositeDisposable.add(
                fetchNewHeadlinesRepo.fetchNewsHeadLinesRepo()
                    .subscribeOn(Schedulers.io())
                    .doOnSuccess {


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


        }
    }


    override fun onCreate() {}
}