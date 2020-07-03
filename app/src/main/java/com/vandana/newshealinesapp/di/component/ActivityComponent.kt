package com.vandana.newshealinesapp.di.component

import com.vandana.newshealinesapp.ui.main.MainActivity
import com.vandana.newshealinesapp.di.ActivityScope
import com.vandana.newshealinesapp.di.module.ActivityModule
import com.vandana.newshealinesapp.ui.detail.DetailActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)
    fun inject(activity: DetailActivity)
}
