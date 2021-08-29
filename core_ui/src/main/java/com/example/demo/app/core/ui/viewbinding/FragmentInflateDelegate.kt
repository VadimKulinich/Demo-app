package com.example.demo.app.core.ui.viewbinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class FragmentInflateDelegate<V : ViewBinding>(
    private val factory: (LayoutInflater, ViewGroup?, Boolean) -> V,
    private val fragment: Fragment
) : ReadOnlyProperty<Fragment, V> {

    private var binding: V? = null

    init {
        fragment.lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                fragment.viewLifecycleOwnerLiveData.observe(fragment) { lifeCycleOwner ->
                    lifeCycleOwner.lifecycle.addObserver(object : DefaultLifecycleObserver {
                        override fun onDestroy(owner: LifecycleOwner) {
                            binding = null
                        }
                    })
                }
            }
        })
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): V =
        binding ?: createBinding(thisRef)

    private fun createBinding(thisRef: Fragment): V {
        val b = factory(thisRef.layoutInflater, null, false)
        binding = b
        return b
    }
}
