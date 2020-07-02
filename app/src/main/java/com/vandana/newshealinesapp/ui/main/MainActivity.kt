package com.vandana.newshealinesapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.vandana.newshealinesapp.R
import com.vandana.newshealinesapp.di.component.ActivityComponent
import com.vandana.newshealinesapp.ui.base.BaseActivity

class MainActivity : BaseActivity<MainViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun setupView(savedInstanceState: Bundle?) {
    }

    override fun injectDependencies(activityComponent: ActivityComponent) = activityComponent.inject(this)

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment, "TAG")
            .commitAllowingStateLoss()
    }

}