package com.example.demo.app.uilts.provider

import android.content.res.Resources
import androidx.annotation.StringRes

class ResourceStringProvider(
    private val resource: Resources
) : StringProvider {

    override fun getString(@StringRes resId: Int): String =
        resource.getString(resId)

    override fun getString(@StringRes resId: Int, vararg args: Any): String =
        resource.getString(resId, *args)
}