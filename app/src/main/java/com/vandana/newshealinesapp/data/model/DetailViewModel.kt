package com.vandana.newshealinesapp.data.model

import com.vandana.newshealinesapp.data.db.DatabaseService
import com.vandana.newshealinesapp.di.ActivityScope
import com.vandana.newshealinesapp.ui.base.BaseViewModel
import com.vandana.newshealinesapp.utils.network.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

@ActivityScope
class DetailViewModel(
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseViewModel(compositeDisposable,networkHelper){

    override fun onCreate() {

    }
}