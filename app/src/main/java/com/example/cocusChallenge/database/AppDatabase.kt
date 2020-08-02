package com.example.cocusChallenge.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cocusChallenge.database.dao.ChallengeDao
import com.example.cocusChallenge.database.dao.UserDao
import com.example.cocusChallenge.database.entities.DbChallenge
import com.example.cocusChallenge.database.entities.DbUser

@Database(
    entities = [
        DbUser::class,
        DbChallenge::class
    ],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun challengeDao(): ChallengeDao
}