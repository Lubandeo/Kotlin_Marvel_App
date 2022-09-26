package com.example.appmarvel.di

import androidx.room.Room
import com.example.appmarvel.R
import com.example.appmarvel.database.MarvelDB
import org.koin.dsl.module

object DBModule {

    val dbModule = module {
        single {
            Room.databaseBuilder(
                get(),
                MarvelDB::class.java,
                R.string.repository_name.toString()
            ).build()
        }
        single { get<MarvelDB>().marvelDaO() }
    }
}
