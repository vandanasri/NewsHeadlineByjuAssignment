package com.vandana.newshealinesapp.di.module

import android.content.Context
import com.vandana.newshealinesapp.di.ActivityContext
import com.vandana.newshealinesapp.ui.base.BaseActivity
import com.vandana.newshealinesapp.ui.main.MainViewModel
import dagger.Module
import dagger.Provides
import androidx.lifecycle.ViewModelProviders

@Module
class ActivityModule (private val activity: BaseActivity<*>) {

    @ActivityContext
    @Provides
    fun provideContext(): Context = activity

    @Provides
    fun provideMainViewModel(
    ): MainViewModel =
        ViewModelProviders.of(activity).get(MainViewModel::class.java)

}
