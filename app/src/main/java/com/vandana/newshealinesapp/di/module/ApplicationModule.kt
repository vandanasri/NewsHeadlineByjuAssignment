package com.vandana.newshealinesapp.di.module

import android.app.Application
import android.content.Context
import com.vandana.newshealinesapp.BuildConfig
import com.vandana.newshealinesapp.NewsHeadlinesApplication
import com.vandana.newshealinesapp.data.remote.NetworkService
import com.vandana.newshealinesapp.data.remote.Networking
import com.vandana.newshealinesapp.di.ApplicationContext
import com.vandana.newshealinesapp.utils.network.NetworkHelper
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
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

    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()

    @Provides
    @Singleton
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(application)

    @Provides
    @Singleton
    fun providesNetworkService() : NetworkService =
        Networking.create(
            BuildConfig.BASE_URL,
            application.cacheDir,
            10 * 1024 * 1024 // 10MB
        )

}