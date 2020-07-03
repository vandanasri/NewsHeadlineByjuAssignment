package com.vandana.newshealinesapp.data.repository

import androidx.room.Delete
import com.vandana.newshealinesapp.data.db.DatabaseService
import com.vandana.newshealinesapp.data.db.NewsHeadlineEntity
import com.vandana.newshealinesapp.data.model.HeadlinesDataModel
import com.vandana.newshealinesapp.data.remote.EndPoints
import com.vandana.newshealinesapp.data.remote.NetworkService
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class FetchNewHeadlinesRepo @Inject constructor(private val networkService: NetworkService, private val databaseService: DatabaseService) {


    //########### Remotely Access ###########
    //to fetch news headline data from server
    fun fetchNewsHeadLinesDataFromRemote(): Single<HeadlinesDataModel> =
        networkService.getTopHeadlines("in", EndPoints.API_KEY)




    //########### Local Access ############
    // to insert news headline data into database
    fun insertData(entity: List<NewsHeadlineEntity> ): Completable = databaseService.getNewsHeadlineDao().insert(entity)

    //to fetch all news headline data from database
    fun fetchNewsHeadlineDataFromDatabase(): Flowable<List<NewsHeadlineEntity>> = databaseService.getNewsHeadlineDao().getAllNewsHeadlineData()

    //to delete Headline Entity
   fun deleteTable() = databaseService.getNewsHeadlineDao().deleteTable()



}