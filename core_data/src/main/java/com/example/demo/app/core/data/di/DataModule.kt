package com.example.demo.app.core.data.di

import androidx.room.Room
import com.example.demo.app.core.data.db.AppDatabase
import com.example.demo.app.core.data.db.SuspendTransactionExecutor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "feed_database").build()
    }
    single { SuspendTransactionExecutor(get()) }
    single { get<AppDatabase>().userDao }
    single { get<AppDatabase>().photoDao }
    single {
        OkHttpClient().newBuilder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }
    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
}