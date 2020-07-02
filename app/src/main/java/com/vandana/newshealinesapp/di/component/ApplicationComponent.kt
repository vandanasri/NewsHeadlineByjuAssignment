package com.vandana.newshealinesapp.di.component

import android.app.Application
import android.content.Context
import com.vandana.newshealinesapp.NewsHeadlinesApplication
import com.vandana.newshealinesapp.di.ApplicationContext
import com.vandana.newshealinesapp.di.module.ApplicationModule
import com.vandana.newshealinesapp.utils.network.NetworkHelper
import dagger.Component
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: NewsHeadlinesApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getApplication(): Application

    fun getCompositeDisposable() : CompositeDisposable

    fun getNetworkHelper(): NetworkHelper
}