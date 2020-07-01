package com.vandana.newshealinesapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vandana.newshealinesapp.R
import com.vandana.newshealinesapp.di.component.ActivityComponent
import com.vandana.newshealinesapp.ui.base.BaseActivity

class MainActivity : BaseActivity<MainViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_main)
    }

    override fun provideLayoutId(): Int {
        TODO("Not yet implemented")
    }

    override fun setupView(savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun injectDependencies(activityComponent: ActivityComponent) {
        TODO("Not yet implemented")
    }
}