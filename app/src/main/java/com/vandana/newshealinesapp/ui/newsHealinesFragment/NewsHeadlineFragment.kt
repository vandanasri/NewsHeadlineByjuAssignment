package com.vandana.newshealinesapp.ui.newsHealinesFragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.vandana.newshealinesapp.R
import com.vandana.newshealinesapp.di.component.FragmentComponent
import com.vandana.newshealinesapp.ui.base.BaseFragment
import com.vandana.newshealinesapp.utils.common.Status
import kotlinx.android.synthetic.main.fragment_headlines.*

class NewsHeadlineFragment : BaseFragment<NewsHeadlineFragmentViewModel>()
{

    private lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun provideLayoutId(): Int = R.layout.fragment_headlines

    override fun injectDependencies(fragmentComponent: FragmentComponent) = fragmentComponent.inject(this)

    override fun setupView(view: View) {
        viewModel.getNewsHeadlinesData()
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.isLoading.observe(this, Observer {
            when (it.status) {
                Status.LOADING -> progressBar.visibility = View.VISIBLE
                Status.SUCCESS -> progressBar.visibility = View.GONE
                Status.ERROR -> progressBar.visibility = View.GONE
                else -> progressBar.visibility = View.GONE
            }
        })
    }
}