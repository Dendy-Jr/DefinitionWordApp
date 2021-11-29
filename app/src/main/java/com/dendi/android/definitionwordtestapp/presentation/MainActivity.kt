package com.dendi.android.definitionwordtestapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dendi.android.definitionwordtestapp.R
import com.dendi.android.definitionwordtestapp.core.WordApp
import com.dendi.android.definitionwordtestapp.databinding.ActivityMainBinding
/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding by lazy {
        checkNotNull(_binding)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, WordsFragment())
                .commit()
        }
    }

    private fun AppCompatActivity.inject() {
        val application = this.application
        if (application is WordApp) {
            application.component.inject(this@MainActivity)
        }
    }
}