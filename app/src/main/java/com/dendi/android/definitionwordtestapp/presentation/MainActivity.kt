package com.dendi.android.definitionwordtestapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.Menu
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener
import androidx.lifecycle.LifecycleOwner
import com.dendi.android.definitionwordtestapp.R
import com.dendi.android.definitionwordtestapp.core.Navigator
import com.dendi.android.definitionwordtestapp.core.WordApp
import com.dendi.android.definitionwordtestapp.databinding.ActivityMainBinding
import com.dendi.android.definitionwordtestapp.presentation.fragments.WordsFragment

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
class MainActivity : AppCompatActivity(), Navigator {

    private var _binding: ActivityMainBinding? = null
    private val binding by lazy {
        checkNotNull(_binding)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        if (savedInstanceState == null) {
            startFragment(WordsFragment())
        }
    }

    private fun AppCompatActivity.inject() {
        val application = this.application
        if (application is WordApp) {
            application.component.inject(this@MainActivity)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        back()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        updateUi()
        return true
    }

    private fun updateUi() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
        } else {
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
            supportActionBar?.setDisplayShowHomeEnabled(false)
        }
    }

    //Needed to use in the future
    override fun <T : Parcelable> publishResult(result: T) {
        supportFragmentManager.setFragmentResult(
            result.javaClass.name,
            bundleOf(KEY_RESULT to result)
        )
    }

    //Needed to use in the future
    override fun <T : Parcelable> listenerResult(
        clazz: Class<T>,
        owner: LifecycleOwner,
        listener: (T) -> Unit
    ) {
        supportFragmentManager.setFragmentResultListener(
            clazz.name,
            owner,
            FragmentResultListener { key, bundle ->
                listener.invoke(bundle.getParcelable(KEY_RESULT)!!)
            })
    }

    override fun startFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit()
    }

    override fun launchFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun back() {
        onBackPressed()
    }

    companion object {
        @JvmStatic
        private val KEY_RESULT = "RESULT"
    }
}