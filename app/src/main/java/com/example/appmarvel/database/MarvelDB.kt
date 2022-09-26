package com.example.appmarvel.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CharacterEntity::class],
    version = 1
)
abstract class MarvelDB : RoomDatabase() {
    abstract fun marvelDaO(): MarvelDaO
}
