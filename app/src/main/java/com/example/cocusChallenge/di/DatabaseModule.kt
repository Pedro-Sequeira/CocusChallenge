package com.example.cocusChallenge.di

import android.content.Context
import androidx.room.Room
import com.example.cocusChallenge.database.AppDatabase
import com.example.cocusChallenge.database.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "cocusChallenge.db"
        ).build()

    @Provides
    fun provideUserDao(database: AppDatabase): UserDao = database.userDao()

}