package com.example.appmarvel.di

import com.example.appmarvel.usecase.GetCharacterByIdUseCase
import com.example.appmarvel.usecase.GetCharacterByIdUseCaseImpl
import com.example.appmarvel.usecase.GetCharactersListUseCase
import com.example.appmarvel.usecase.GetCharactersListUseCaseImpl
import org.koin.dsl.module

object UseCaseModule {
    val useCaseModule = module {
        factory<GetCharactersListUseCase> { GetCharactersListUseCaseImpl(get(), get()) }
        factory<GetCharacterByIdUseCase> { GetCharacterByIdUseCaseImpl(get(), get()) }
    }
}
