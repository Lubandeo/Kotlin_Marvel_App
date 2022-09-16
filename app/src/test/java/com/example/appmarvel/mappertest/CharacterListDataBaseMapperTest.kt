package com.example.appmarvel.mappertest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.appmarvel.database.CharacterEntity
import com.example.appmarvel.service.response.CharacterResponse
import com.example.appmarvel.service.response.ResultResponse
import com.example.appmarvel.service.utils.transformListCharacterEntity
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class CharacterListDataBaseMapperTest {

    private lateinit var resultResponse: ResultResponse
    private lateinit var listOfEntity: List<CharacterEntity>

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        resultResponse = ResultResponse(mutableListOf(CharacterResponse(ID, NAME, DESCRIPTION)))
        listOfEntity = listOf(CharacterEntity(ID, NAME, DESCRIPTION))
    }

    @Test
    fun `transforming list of Character Entity into list of Character`() {
        val transformation = listOfEntity.transformListCharacterEntity()

        assertEquals(ID, transformation.first().id)
        assertEquals(NAME, transformation.first().name)
        assertEquals(DESCRIPTION, transformation.first().description)
    }

    companion object {
        const val ID = "1"
        const val NAME = "Juan"
        const val DESCRIPTION = "el amigo de Juan"
    }
}
