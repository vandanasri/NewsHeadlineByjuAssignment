package com.vandana.newshealinesapp.ui.newsHealinesFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vandana.newshealinesapp.R
import com.vandana.newshealinesapp.data.db.NewsHeadlineEntity
import kotlinx.android.synthetic.main.item_headlines.view.*

class NewsHeadlineAdapter (private var newsHeadlineDataList: List<NewsHeadlineEntity>) :
    RecyclerView.Adapter<NewsHeadlineAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_headlines, parent, false)
        return ViewHolder(parent.context, view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return newsHeadlineDataList.size
    }

    private fun getItem(position: Int): NewsHeadlineEntity {
        return newsHeadlineDataList[position]
    }

    class ViewHolder(private var mContext: Context, itemView: View) :
        RecyclerView.ViewHolder(itemView) {


        fun bind(value: NewsHeadlineEntity) {
            itemView.tvTitleName.text = value.title
            itemView.tvSourceName.text = value.source
            itemView.tvDate.text = value.publishedAt
            Glide.with(itemView.context).load(value.url).into(itemView.imageView)



        }
    }


    }