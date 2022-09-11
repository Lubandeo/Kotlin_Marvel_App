package com.example.appmarvel.mappertest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.appmarvel.service.response.CharacterResponse
import com.example.appmarvel.service.response.DataResponse
import com.example.appmarvel.service.response.ResultResponse
import com.example.appmarvel.service.utils.transformData
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CharacterListMapperTest {

    private lateinit var resultResponse: ResultResponse
    private lateinit var dataResponse: DataResponse

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        resultResponse = ResultResponse(
            mutableListOf(
                CharacterResponse(ID, NAME, DESCRIPTION)
            )
        )
        dataResponse = DataResponse(resultResponse)
    }

    @Test
    fun `transforming data response to character list`() {
        val response = dataResponse.transformData()

        assertEquals(response[0].id, resultResponse.results[0].id)
        assertEquals(response[0].name, resultResponse.results[0].name)
        assertEquals(response[0].description, resultResponse.results[0].description)
    }

    companion object {
        const val ID = "1"
        const val NAME = "Juan"
        const val DESCRIPTION = "el amigo de Juan"
    }
}
