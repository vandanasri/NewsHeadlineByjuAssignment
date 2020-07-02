package com.vandana.newshealinesapp.data.remote

import com.vandana.newshealinesapp.data.model.HeadlinesDataModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {


    @GET(EndPoints.HEADLINE_ENDPOINTS)
    fun getTopHeadlines(@Query("country") country:String,
                        @Query("apiKey") appKey:String): Single<HeadlinesDataModel>






}