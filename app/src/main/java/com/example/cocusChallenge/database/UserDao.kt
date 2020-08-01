package com.example.cocusChallenge.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM $USERS_TABLE_NAME ORDER BY searchDate DESC LIMIT 5")
    fun getUsers(): List<DbUser>?

    @Query("SELECT * FROM $USERS_TABLE_NAME ORDER BY searchDate DESC LIMIT 5")
    fun getUsersByRank(): List<DbUser>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(users: DbUser)

    @Query("SELECT * FROM $USERS_TABLE_NAME WHERE username = :username")
    fun getUser(username: String): DbUser?

    @Query("DELETE FROM $USERS_TABLE_NAME")
    suspend fun clearUsers()

}