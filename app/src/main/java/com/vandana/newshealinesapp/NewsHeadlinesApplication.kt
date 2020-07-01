package com.vandana.newshealinesapp

import android.app.Application
import com.vandana.newshealinesapp.di.component.ApplicationComponent
import com.vandana.newshealinesapp.di.component.DaggerApplicationComponent
import com.vandana.newshealinesapp.di.module.ApplicationModule

class NewsHeadlinesApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}