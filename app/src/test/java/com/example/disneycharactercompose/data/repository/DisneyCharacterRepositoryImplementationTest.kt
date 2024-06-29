package com.example.disneycharactercompose.data.repository

import com.example.disneycharactercompose.data.api.APIEndpoints
import com.example.disneycharactercompose.data.model.DataModel
import com.example.disneycharactercompose.data.model.DisneyCharacterModel
import com.example.disneycharactercompose.data.model.InfoModel
import org.junit.Assert.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations


@ExperimentalCoroutinesApi
class DisneyCharacterRepositoryImplementationTest{

    @Mock
    private lateinit var apiDetail:APIEndpoints

    private lateinit var disneyCharacterRepository: DisneyCharacterRepositoryImplementation

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        disneyCharacterRepository = DisneyCharacterRepositoryImplementation(apiDetail)
    }
    @Test
    fun `getCharacterFromList should return Disney character`() = runTest {
        // Given
        val dataModels = listOf(
            DataModel(id = 1, name = "Mickey Mouse"),
            DataModel(id = 2, name = "Donald Duck")
        )

        val infoModel = InfoModel(count = 2, totalPages = 1, nextPage = null, previousPage = null)
        val disneyCharacter = DisneyCharacterModel(data = dataModels, info = infoModel)
        `when`(apiDetail.getCharacterFromList()).thenReturn(disneyCharacter)

        // When
        val result = disneyCharacterRepository.getCharacterFromList()

        // Then
        assertEquals(disneyCharacter, result)
        verify(apiDetail).getCharacterFromList()
    }
}