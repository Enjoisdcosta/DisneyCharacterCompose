package com.example.disneycharactercompose.ui.viewmodel

import org.junit.Assert.*
import app.cash.turbine.test
import com.example.disneycharactercompose.data.model.DataModel
import com.example.disneycharactercompose.data.model.DisneyCharacterModel
import com.example.disneycharactercompose.data.model.InfoModel
import com.example.disneycharactercompose.data.repository.DisneyCharacterRepositoryImplementation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import androidx.arch.core.executor.testing.InstantTaskExecutorRule


class DisneyCharacterViewModelTest {


    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: DisneyCharacterRepositoryImplementation

    private lateinit var disneyCharacterViewModel: DisneyCharacterViewModel

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        disneyCharacterViewModel = DisneyCharacterViewModel(repository)
    }

    @Test
    fun `selectCharacter should emit Disney character`() = runTest {
        // Given
        val dataModels = listOf(
            DataModel(id = 1, name = "Mickey Mouse"),
            DataModel(id = 2, name = "Donald Duck")
        )
        val infoModel = InfoModel(count = 2, totalPages = 1, nextPage = null, previousPage = null)
        val disneyCharacter = DisneyCharacterModel(data = dataModels, info = infoModel)
        `when`(repository.getCharacterFromList()).thenReturn(disneyCharacter)

        // When
        advanceUntilIdle() // Advance coroutine execution

        // Then
        disneyCharacterViewModel.selectCharacter.test {
            assertEquals(disneyCharacter, awaitItem())
        }

        verify(repository).getCharacterFromList()
    }
}