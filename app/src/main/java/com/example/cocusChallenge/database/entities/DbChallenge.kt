package com.example.cocusChallenge.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val CHALLENGES_TABLE_NAME = "challenges_table"

@Entity(tableName = CHALLENGES_TABLE_NAME)
data class DbChallenge(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "completedAt")
    val completedAt: String?,

    @ColumnInfo(name = "user")
    val user: String?
)