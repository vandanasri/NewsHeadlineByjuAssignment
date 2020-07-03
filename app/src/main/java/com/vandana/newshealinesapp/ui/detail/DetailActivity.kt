package com.vandana.newshealinesapp.ui.detail

import android.os.Bundle
import com.bumptech.glide.Glide
import com.vandana.newshealinesapp.R
import com.vandana.newshealinesapp.data.model.DetailViewModel
import com.vandana.newshealinesapp.di.component.ActivityComponent
import com.vandana.newshealinesapp.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity<DetailViewModel>() {

    override fun provideLayoutId(): Int = R.layout.activity_detail

    override fun injectDependencies(activityComponent: ActivityComponent) = activityComponent.inject(this)

    override fun setupView(savedInstanceState: Bundle?) {


        Glide.with(this).load(intent.getStringExtra("url")).into(ivDetail)
        tvDetailTitleName.text= intent.getStringExtra("title")
        tvDescription.text= intent.getStringExtra("desc")
        tvDate.text= intent.getStringExtra("date")
        tvDetailSourceName.text = intent.getStringExtra("source")

        ivBack.setOnClickListener {
            finish()
        }
    }
}