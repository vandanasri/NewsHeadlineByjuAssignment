package com.vandana.newshealinesapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class HeadlinesDataModel(
    @SerializedName("status")
    @Expose
    var  status:String? = null,
    @SerializedName("totalResults")
    @Expose
    var  totalResults:Integer? =null,
    @SerializedName("articles")
    @Expose
    var articles: List<Article>?  = null

)
{
    inner class Source
    {

        @SerializedName("id")
        @Expose
        var id: Any? = null

        @SerializedName("name")
        @Expose
        var name: String? = null
}

    inner class Article{

        @SerializedName("source")
        @Expose
        var source:Source? = null

        @SerializedName("author")
        @Expose
        var author:String? =null
        @SerializedName("title")
        @Expose
        var title:String? =null

        @SerializedName("description")
        @Expose
        var description:String? =null
        @SerializedName("url")
        @Expose
        var url: String? =null
        @SerializedName("urlToImage")
        @Expose
        var urlToImage:String?= null
        @SerializedName("publishedAt")
        @Expose
        var publishedAt:String?=null
        @SerializedName("content")
        @Expose
        var content:String? = null

    }
}


