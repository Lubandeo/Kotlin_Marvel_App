package com.example.appmarvel.di

import com.example.appmarvel.database.MarvelRepository
import com.example.appmarvel.database.MarvelRepositoryImpl
import org.koin.dsl.module

object RepositoryModule {
    val repositoryModule = module {
        factory<MarvelRepository> { MarvelRepositoryImpl(get()) }
    }
}
