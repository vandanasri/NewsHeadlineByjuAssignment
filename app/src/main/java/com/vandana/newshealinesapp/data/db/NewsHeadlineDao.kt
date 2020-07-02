package com.vandana.newshealinesapp.data.db

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface NewsHeadlineDao{

    @Query("SELECT * FROM "+ DbConstants.NEWS_HEADLINE_TABLE)
    fun getAllNewsHeadlineData() : Flowable<List<NewsHeadlineEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: List<NewsHeadlineEntity> ) : Completable

    @Delete
    fun delete(entity: NewsHeadlineEntity)


    @Query("SELECT COUNT("+ DbConstants.NEWS_HEADLINE_TITLE+") FROM " +DbConstants.NEWS_HEADLINE_TABLE)
    fun getDataCount() : Flowable<Int>


}