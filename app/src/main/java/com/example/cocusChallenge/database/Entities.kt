package com.example.cocusChallenge.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val USERS_TABLE_NAME = "users_table"

@Entity(tableName = USERS_TABLE_NAME)
data class DbUser(
    @PrimaryKey
    @ColumnInfo(name = "username")
    val username: String,

    @ColumnInfo(name = "leaderBoardPosition")
    val leaderBoardPosition: Int?,

    @ColumnInfo(name = "honor")
    val honor: Int,

    @ColumnInfo(name = "rankName")
    val rankName: String,

    @ColumnInfo(name = "bestLanguage")
    val bestLanguage: String?,

    @ColumnInfo(name = "searchDate")
    var searchDate: Long
)