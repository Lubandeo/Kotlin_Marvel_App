package com.example.appmarvel.usecasetest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.appmarvel.database.MarvelRepository
import com.example.appmarvel.entity.Character
import com.example.appmarvel.service.serviceinterface.MarvelService
import com.example.appmarvel.service.utils.Result
import com.example.appmarvel.usecase.GetCharactersListUseCase
import com.example.appmarvel.usecase.GetCharactersListUseCaseImpl
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetCharactersListUseCaseTest {

    private val marvelService: MarvelService = mock()
    private val marvelDatabase: MarvelRepository = mock()
    private val listOfCharacters: List<Character> = mock()
    private lateinit var getCharactersListUseCase: GetCharactersListUseCase

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        getCharactersListUseCase = GetCharactersListUseCaseImpl(marvelService, marvelDatabase)
    }

    @Test
    fun `when service result returns success`() {
        whenever(marvelService.getCharactersList()).thenReturn(Result.Success(listOfCharacters))
        whenever(marvelDatabase.getCharacters()).thenReturn(Result.Success(listOfCharacters))
        val result = getCharactersListUseCase()

        verify(marvelDatabase).updateCharacters(listOfCharacters)
        verify(marvelDatabase).getCharacters()
        assertEquals(listOfCharacters, (result as Result.Success).data)
    }

    @Test
    fun `when service result returns failure - empty database`() {
        whenever(marvelService.getCharactersList()).thenReturn(Result.Failure(Exception(CHARACTERS_NOT_FOUND)))
        whenever(marvelDatabase.getCharacters()).thenReturn(Result.Failure(Exception(CHARACTERS_NOT_FOUND)))
        val result = getCharactersListUseCase()

        verify(marvelDatabase).getCharacters()
        assertEquals(CHARACTERS_NOT_FOUND, (result as Result.Failure).exception.message)
    }

    @Test
    fun `when service result returns failure - database has data`() {
        whenever(marvelService.getCharactersList()).thenReturn(Result.Failure(Exception(CHARACTERS_NOT_FOUND)))
        whenever(marvelDatabase.getCharacters()).thenReturn(Result.Success(listOfCharacters))
        val result = getCharactersListUseCase()

        verify(marvelDatabase).getCharacters()
        assertEquals(listOfCharacters, (result as Result.Success).data)
    }

    companion object {
        private const val CHARACTERS_NOT_FOUND = "CHARACTERS_NOT_FOUND"
    }
}
