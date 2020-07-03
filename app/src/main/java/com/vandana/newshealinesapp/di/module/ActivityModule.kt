package com.vandana.newshealinesapp.di.module

import android.content.Context
import com.vandana.newshealinesapp.di.ActivityContext
import com.vandana.newshealinesapp.ui.base.BaseActivity
import com.vandana.newshealinesapp.ui.main.MainViewModel
import dagger.Module
import dagger.Provides
import androidx.lifecycle.ViewModelProviders
import com.vandana.newshealinesapp.data.model.DetailViewModel
import com.vandana.newshealinesapp.ui.newsHealinesFragment.NewsHeadlineFragmentViewModel
import com.vandana.newshealinesapp.utils.ViewModelProviderFactory
import com.vandana.newshealinesapp.utils.network.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule (private val activity: BaseActivity<*>) {

    @ActivityContext
    @Provides
    fun provideContext(): Context = activity

    @Provides
    fun provideMainViewModel(compositeDisposable: CompositeDisposable,
                             networkHelper: NetworkHelper
    ): MainViewModel =
        ViewModelProviders.of(activity,ViewModelProviderFactory(MainViewModel::class){
            MainViewModel(compositeDisposable,networkHelper)
        }
        ).get(MainViewModel::class.java)


    @Provides
    fun provideDetailViewModel(compositeDisposable: CompositeDisposable,
                             networkHelper: NetworkHelper
    ): DetailViewModel =
        ViewModelProviders.of(activity,ViewModelProviderFactory(DetailViewModel::class){
            DetailViewModel(compositeDisposable,networkHelper)
        }).get(DetailViewModel::class.java)

}
