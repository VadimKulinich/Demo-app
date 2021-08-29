package com.example.demo.app.uilts.provider

import androidx.annotation.StringRes

interface StringProvider {

    fun getString(@StringRes resId: Int): String

    fun getString(@StringRes resId: Int, vararg args: Any): String
}