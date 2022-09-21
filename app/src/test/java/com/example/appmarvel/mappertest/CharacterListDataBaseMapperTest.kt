package com.example.appmarvel.mappertest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.appmarvel.database.CharacterEntity
import com.example.appmarvel.service.response.CharacterResponse
import com.example.appmarvel.service.response.ImageResponse
import com.example.appmarvel.service.response.ResultResponse
import com.example.appmarvel.service.utils.extension.getURL
import com.example.appmarvel.service.utils.extension.transformListCharacterEntity
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class CharacterListDataBaseMapperTest {

    private lateinit var resultResponse: ResultResponse
    private lateinit var listOfEntity: List<CharacterEntity>
    private lateinit var imageResponse: ImageResponse

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        imageResponse = ImageResponse(PATH, EXTENSION)
        resultResponse =
            ResultResponse(mutableListOf(CharacterResponse(ID, NAME, DESCRIPTION, imageResponse)))
        listOfEntity = listOf(CharacterEntity(ID, NAME, DESCRIPTION, imageResponse.getURL()))
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
        const val PATH = "http://urldeprueba.com/docs/marvelmovies/avengers"
        const val EXTENSION = "jpg"
    }
}
