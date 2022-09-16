package com.example.appmarvel.mappertest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import com.example.appmarvel.entity.Character
import com.example.appmarvel.service.utils.transformCharacter
import org.junit.Assert.assertEquals

@RunWith(MockitoJUnitRunner::class)
class CharacterDataBaseMapperTest {

    private lateinit var  character: Character

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun init(){
        character = Character(ID,NAME,DESCRIPTION)
    }

    @Test
    fun `transforming Character to CharacterEntity`(){
        val transformation = character.transformCharacter()

        assertEquals(ID, transformation.id)
        assertEquals(NAME,transformation.name)
        assertEquals(DESCRIPTION, transformation.description)
    }

    companion object {
        const val ID = "1"
        const val NAME = "Juan"
        const val DESCRIPTION = "el amigo de Juan"
    }
}
