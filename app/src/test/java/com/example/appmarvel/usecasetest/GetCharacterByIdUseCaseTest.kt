package com.example.appmarvel.usecasetest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.appmarvel.database.MarvelRepository
import com.example.appmarvel.entity.Character
import com.example.appmarvel.service.serviceinterface.MarvelService
import com.example.appmarvel.service.utils.Result
import com.example.appmarvel.usecase.GetCharacterByIdUseCase
import com.example.appmarvel.usecase.GetCharacterByIdUseCaseImpl
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
class GetCharacterByIdUseCaseTest {

    private val marvelService: MarvelService = mock()
    private val marvelRepository: MarvelRepository = mock()
    private lateinit var character: Character
    private lateinit var getCharacterByIdUseCase: GetCharacterByIdUseCase

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        character = Character(ID, NAME, DESCRIPTION, URL)
        getCharacterByIdUseCase = GetCharacterByIdUseCaseImpl(marvelService, marvelRepository)
    }

    @Test
    fun `when service result returns success`() {
        whenever(marvelService.getCharacterById(ID)).thenReturn(Result.Success(character))
        whenever(marvelRepository.getCharacterById(ID)).thenReturn(Result.Success(character))
        val result = getCharacterByIdUseCase(character.id)

        verify(marvelRepository).updateCharacterById(character)
        verify(marvelRepository).getCharacterById(character.id)
        assertEquals(character, (result as Result.Success).data)
    }

    @Test
    fun `when service result returns failure - empty database`() {
        whenever(marvelService.getCharacterById(ID)).thenReturn(
            Result.Failure(
                Exception(
                    CHARACTER_NOT_FOUND
                )
            )
        )
        whenever(marvelRepository.getCharacterById(ID)).thenReturn(
            Result.Failure(
                Exception(
                    CHARACTER_NOT_FOUND
                )
            )
        )
        val result = getCharacterByIdUseCase(character.id)

        verify(marvelRepository).getCharacterById(character.id)
        assertEquals(CHARACTER_NOT_FOUND, (result as Result.Failure).exception.message)
    }

    @Test
    fun `when service result returns failure - database has data`() {
        whenever(marvelService.getCharacterById(INVALID_ID)).thenReturn(
            Result.Failure(
                Exception(
                    CHARACTER_NOT_FOUND
                )
            )
        )
        whenever(marvelRepository.getCharacterById(INVALID_ID)).thenReturn(Result.Success(character))
        val result = getCharacterByIdUseCase(INVALID_ID)

        verify(marvelRepository).getCharacterById(INVALID_ID)
        assertEquals(character, (result as Result.Success).data)
    }

    companion object {
        private const val CHARACTER_NOT_FOUND = "CHARACTER_NOT_FOUND"
        private const val ID = "1017100"
        private const val NAME = "Juan"
        private const val DESCRIPTION = "el amigo de Juan"
        private const val URL = "http://urldeprueba.com/docs/marvelmovies/avengers.jpg"
        private const val INVALID_ID = "240199"
    }
}
