package com.vandana.newshealinesapp.di.component

import com.vandana.newshealinesapp.di.FragmentScope
import com.vandana.newshealinesapp.di.module.FragmentModule
import com.vandana.newshealinesapp.ui.newsHealinesFragment.NewsHeadlineFragment
import dagger.Component


@FragmentScope
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(fragment: NewsHeadlineFragment)
}