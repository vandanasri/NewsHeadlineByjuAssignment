package com.vandana.newshealinesapp.ui.newsHealinesFragment

import com.vandana.newshealinesapp.di.FragmentScope
import com.vandana.newshealinesapp.ui.base.BaseViewModel
import com.vandana.newshealinesapp.utils.network.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

@FragmentScope
class NewsHeadlineFragmentViewModel(compositeDisposable: CompositeDisposable,
                                    networkHelper: NetworkHelper)
    :BaseViewModel(compositeDisposable,networkHelper) {
    override fun onCreate() {

    }
}