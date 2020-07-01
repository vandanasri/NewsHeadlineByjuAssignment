package com.vandana.newshealinesapp.di.module

import android.app.Application
import android.content.Context
import com.vandana.newshealinesapp.NewsHeadlinesApplication
import com.vandana.newshealinesapp.di.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: NewsHeadlinesApplication) {

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Context = application

}