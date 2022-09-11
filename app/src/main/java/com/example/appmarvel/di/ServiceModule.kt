package com.example.appmarvel.di

import com.example.appmarvel.service.serviceimplementation.MarvelServiceImpl
import com.example.appmarvel.service.serviceinterface.MarvelService
import org.koin.dsl.module

object ServiceModule {
    val serviceModule = module {
        factory<MarvelService> { MarvelServiceImpl(get()) }
    }
}
