package com.example.disneycharactercompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneycharactercompose.data.model.DataModel
import com.example.disneycharactercompose.data.model.DisneyCharacterModel
import com.example.disneycharactercompose.data.repository.DisneyCharacterRepositoryImplementation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DisneyCharacterViewModel @Inject constructor(
    private val repository: DisneyCharacterRepositoryImplementation
): ViewModel(){

    private val _selectCharacter = MutableStateFlow<DisneyCharacterModel?>(null)
    val selectCharacter: StateFlow<DisneyCharacterModel?> = _selectCharacter

    init {
        viewModelScope.launch {
           _selectCharacter.value = repository.getCharacterFromList()
        }
    }




}