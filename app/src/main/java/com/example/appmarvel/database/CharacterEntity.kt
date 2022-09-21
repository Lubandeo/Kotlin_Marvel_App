package com.example.appmarvel.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character_table")
class CharacterEntity(
    @PrimaryKey val id: String,
    val name: String,
    val description: String,
    val imageURL: String
)
