package com.example.cocuschallenge.di

import com.example.cocuschallenge.api.CodewarsApi
import com.example.cocuschallenge.api.CodewarsApi.Companion.BASE_URL
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object NetworkModule {

    @Provides
    fun provideCoroutineScopeIO() = CoroutineScope(Dispatchers.IO)

    @Singleton
    @Provides
    fun provideApiService(converterFactory: GsonConverterFactory) =
        provideService(
            converterFactory,
            CodewarsApi::class.java
        )

    @Singleton
    @Provides
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)

    @Singleton
    @Provides
    fun provideGson(): Gson = Gson()

    private fun <T> provideService(
        converterFactory: GsonConverterFactory,
        clazz: Class<T>
    ): T = createRetrofit(converterFactory).create(clazz)

    private fun createRetrofit(
        converterFactory: GsonConverterFactory
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(converterFactory)
            .build()
}