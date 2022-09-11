package com.example.appmarvel.di

import com.example.appmarvel.service.ServiceGenerator
import org.koin.dsl.module

object ApiModule {
    val apiModule = module {
        factory { ServiceGenerator() }
    }
}
