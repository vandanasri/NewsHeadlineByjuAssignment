package com.vandana.newshealinesapp.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.vandana.newshealinesapp.ui.base.BaseFragment
import com.vandana.newshealinesapp.ui.newsHealinesFragment.NewsHeadlineFragmentViewModel
import com.vandana.newshealinesapp.utils.ViewModelProviderFactory
import com.vandana.newshealinesapp.utils.network.NetworkHelper
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class FragmentModule(private val fragment: BaseFragment<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(fragment.context)

    @Provides
    fun providesNewsHeadlineViewModel(
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
    ) : NewsHeadlineFragmentViewModel =
        ViewModelProviders.of(fragment, ViewModelProviderFactory(NewsHeadlineFragmentViewModel::class){
            NewsHeadlineFragmentViewModel(compositeDisposable, networkHelper)
        }).get(NewsHeadlineFragmentViewModel::class.java)
}