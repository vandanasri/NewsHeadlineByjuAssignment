package com.vandana.newshealinesapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import javax.inject.Singleton


@Singleton
@Database(
    entities = [NewsHeadlineEntity::class], exportSchema = false, version = 1
)
abstract class DatabaseService : RoomDatabase() {

    abstract fun getNewsHeadlineDao() : NewsHeadlineDao
}