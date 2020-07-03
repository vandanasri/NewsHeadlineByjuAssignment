package com.vandana.newshealinesapp.data.db

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.io.IOException

class NewsHeadlineDaoTest {


    private lateinit var newsHeadlineDao: NewsHeadlineDao

    private lateinit var mDatabase: DatabaseService

    private val newsHeadlineEntityList: ArrayList<NewsHeadlineEntity> = ArrayList()


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        mDatabase = Room.inMemoryDatabaseBuilder(
            context, DatabaseService::class.java
        )
            .allowMainThreadQueries()
            .build()

        newsHeadlineDao = mDatabase.getNewsHeadlineDao()

    }


    @Test
    fun insertNasaData() {
        newsHeadlineEntityList.add(NewsHeadlineEntity( "title1", "url1", "description1", "CNN","20/5/20" ))

        mDatabase.clearAllTables()
        newsHeadlineDao.insert(newsHeadlineEntityList).blockingAwait()

        newsHeadlineDao.getAllNewsHeadlineData()
            .test()
            .assertValueCount(1)


    }


    @After
    @Throws(IOException::class)
    fun closeDb() {
        mDatabase.close()
    }
}