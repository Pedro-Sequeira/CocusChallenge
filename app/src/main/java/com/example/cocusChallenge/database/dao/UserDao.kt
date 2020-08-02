package com.example.cocusChallenge.database.dao

import androidx.room.*
import com.example.cocusChallenge.database.entities.DbUser
import com.example.cocusChallenge.database.entities.USERS_TABLE_NAME
import com.example.cocusChallenge.database.entities.UserWithChallenges

@Dao
interface UserDao {

    @Query("SELECT * FROM $USERS_TABLE_NAME ORDER BY searchDate DESC LIMIT 5")
    fun getUsers(): List<DbUser>?

    @Transaction
    @Query("SELECT * FROM $USERS_TABLE_NAME")
    fun getUsersWithChallenges(): List<UserWithChallenges>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(users: DbUser)

    @Query("SELECT * FROM $USERS_TABLE_NAME WHERE username = :username")
    fun getUser(username: String): DbUser?

}