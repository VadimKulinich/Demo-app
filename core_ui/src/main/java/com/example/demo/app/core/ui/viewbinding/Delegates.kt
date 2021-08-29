package com.example.demo.app.core.ui.viewbinding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

fun <V : ViewBinding> Fragment.bind(factory: (View) -> V) =
    FragmentBindDelegate(factory, this)

fun <V : ViewBinding> Fragment.inflate(factory: (LayoutInflater, ViewGroup?, Boolean) -> V) =
    FragmentInflateDelegate(factory, this)

inline fun <V : ViewBinding> AppCompatActivity.bind(crossinline factory: (LayoutInflater) -> V) =
    lazy(LazyThreadSafetyMode.NONE) {
        factory(layoutInflater)
    }
