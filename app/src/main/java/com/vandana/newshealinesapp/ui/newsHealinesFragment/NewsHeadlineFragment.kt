package com.vandana.newshealinesapp.ui.newsHealinesFragment

import android.view.View
import com.vandana.newshealinesapp.R
import com.vandana.newshealinesapp.di.component.FragmentComponent
import com.vandana.newshealinesapp.ui.base.BaseFragment

class NewsHeadlineFragment : BaseFragment<NewsHeadlineFragmentViewModel>()
{
    override fun provideLayoutId(): Int = R.layout.fragment_headlines

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        TODO("Not yet implemented")
    }

    override fun setupView(view: View) {
        TODO("Not yet implemented")
    }
}