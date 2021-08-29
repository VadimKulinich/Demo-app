package com.example.demo.app.core.data.model

import androidx.annotation.IntDef

@IntDef(UserPictureType.THUMBNAIL, UserPictureType.MEDIUM, UserPictureType.LARGE)
@Retention(AnnotationRetention.SOURCE)
annotation class UserPictureType {
    companion object {
        const val THUMBNAIL = 1
        const val MEDIUM = 2
        const val LARGE = 3
    }
}