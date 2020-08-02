package com.example.cocusChallenge.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cocusChallenge.database.entities.DbUser
import com.example.cocusChallenge.database.entities.USERS_TABLE_NAME

@Dao
interface UserDao {

    @Query("SELECT * FROM $USERS_TABLE_NAME ORDER BY searchDate DESC LIMIT 5")
    fun getUsers(): List<DbUser>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(users: DbUser)

    @Query("SELECT * FROM $USERS_TABLE_NAME WHERE username = :username")
    fun getUser(username: String): DbUser?

    @Query("DELETE FROM $USERS_TABLE_NAME")
    suspend fun clearUsers()

}