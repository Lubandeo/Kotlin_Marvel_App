package com.example.appmarvel.di

import androidx.room.Room
import com.example.appmarvel.R
import com.example.appmarvel.database.MarvelDataBase
import com.example.appmarvel.database.MarvelDataBaseImpl
import org.koin.dsl.module

object DatabaseModule {
    val databaseModule = module{
        single<MarvelDataBase>{Room.databaseBuilder(get(),MarvelDataBaseImpl::class.java, R.string.database_name.toString()).build()}
        single{get<MarvelDataBaseImpl>().marvelDaO()}
    }
}
