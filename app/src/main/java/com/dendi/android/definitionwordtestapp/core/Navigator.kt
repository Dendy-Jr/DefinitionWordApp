package com.dendi.android.definitionwordtestapp.core

import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner

/**
 * @author Dendy-Jr on 30.11.2021
 * olehvynnytskyi@gmail.com
 */

fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator
}

interface Navigator {

    //Needed to use in the future
    fun <T : Parcelable> publishResult(result: T)

    //Needed to use in the future
    fun <T : Parcelable> listenerResult(
        clazz: Class<T>,
        owner: LifecycleOwner,
        listener: (T) -> Unit,
    )

    fun startFragment(fragment: Fragment)

    fun launchFragment(fragment: Fragment)

    fun back()
}