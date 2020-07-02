package com.vandana.newshealinesapp.data.repository

import com.vandana.newshealinesapp.data.model.HeadlinesDataModel
import com.vandana.newshealinesapp.data.remote.EndPoints
import com.vandana.newshealinesapp.data.remote.NetworkService
import io.reactivex.Single
import javax.inject.Inject

class FetchNewHeadlinesRepo @Inject constructor(private val networkService: NetworkService) {

    //to fetch news headline data from server

    fun fetchNewsHeadLinesRepo(): Single<HeadlinesDataModel> =
        networkService.getTopHeadlines("in", EndPoints.API_KEY)
}