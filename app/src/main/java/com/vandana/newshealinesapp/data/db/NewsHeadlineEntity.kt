package com.vandana.newshealinesapp.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = DbConstants.NEWS_HEADLINE_TABLE)
data class NewsHeadlineEntity(

    @ColumnInfo(name = DbConstants.NEWS_HEADLINE_TITLE)
    @NotNull
    var title: String?,

    @ColumnInfo(name = DbConstants.NEWS_HEADLINE_URL)
    @NotNull
    var url: String?,

    @ColumnInfo(name = DbConstants.NEWS_HEADLINE_DESCRIPTION)
    @NotNull
    var description:String?,

    @ColumnInfo(name = DbConstants.NEWS_HEADLINE_SOURCE)
    @NotNull
    var source:String?,

    @ColumnInfo(name = DbConstants.NEWS_HEADLINE_PUBLISHED_AT)
    @NotNull
    var publishedAt:String?
)
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DbConstants.NEWS_HEADLINE_ID)
    @NotNull
    var id: Int = 0
}