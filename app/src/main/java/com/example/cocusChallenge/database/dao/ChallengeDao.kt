package com.example.cocusChallenge.database.dao

import androidx.room.*
import com.example.cocusChallenge.database.entities.CHALLENGES_TABLE_NAME
import com.example.cocusChallenge.database.entities.DbChallenge
import com.example.cocusChallenge.database.entities.DbUser
import com.example.cocusChallenge.database.entities.USERS_TABLE_NAME
import com.example.cocusChallenge.models.Challenge

@Dao
interface ChallengeDao {

    @Query("SELECT * FROM $CHALLENGES_TABLE_NAME WHERE id = :id")
    fun getChallenge(id: String): DbChallenge?

    @Transaction
    @Query("SELECT * FROM $CHALLENGES_TABLE_NAME WHERE user = :username")
    fun getChallenges(username: String): List<DbChallenge>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChallenge(challenge: DbChallenge)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChallenges(challenges: List<DbChallenge>)

}