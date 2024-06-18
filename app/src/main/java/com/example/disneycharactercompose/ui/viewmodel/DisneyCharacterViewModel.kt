package com.example.disneycharactercompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.disneycharactercompose.data.repository.DisneyCharacterRepositoryImplementation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DisneyCharacterViewModel @Inject constructor(
    private val repository: DisneyCharacterRepositoryImplementation
): ViewModel(){


}