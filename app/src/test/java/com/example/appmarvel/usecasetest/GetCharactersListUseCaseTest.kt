package com.example.appmarvel.usecasetest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.appmarvel.service.serviceinterface.MarvelService
import com.example.appmarvel.usecase.GetCharactersListUseCaseImpl
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class GetCharactersListUseCaseTest {

    private var marvelService: MarvelService = mock()
    private lateinit var getCharactersListUseCase: GetCharactersListUseCaseImpl

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        getCharactersListUseCase = GetCharactersListUseCaseImpl(marvelService)
    }

    @Test
    fun `get characters list from service test`() {
        getCharactersListUseCase.invoke()
        verify(marvelService).getCharactersList()
    }
}
