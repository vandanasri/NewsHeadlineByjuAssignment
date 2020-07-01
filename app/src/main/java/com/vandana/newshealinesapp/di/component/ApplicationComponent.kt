package com.vandana.newshealinesapp.di.component

import android.app.Application
import android.content.Context
import com.vandana.newshealinesapp.NewsHeadlinesApplication
import com.vandana.newshealinesapp.di.ApplicationContext
import com.vandana.newshealinesapp.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: NewsHeadlinesApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getApplication(): Application
}