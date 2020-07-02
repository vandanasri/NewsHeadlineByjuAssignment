package com.vandana.newshealinesapp.ui.main

import com.vandana.newshealinesapp.di.ActivityScope
import com.vandana.newshealinesapp.ui.base.BaseViewModel
import com.vandana.newshealinesapp.utils.network.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

@ActivityScope
class MainViewModel(compositeDisposable: CompositeDisposable,
                    networkHelper: NetworkHelper
): BaseViewModel(compositeDisposable,networkHelper) {

    override fun onCreate() {

    }
}