package com.example.disneycharactercompose.data.repository

import com.example.disneycharactercompose.data.model.DataModel
import com.example.disneycharactercompose.data.model.DisneyCharacterModel

interface DisneyCharacterRepository {
    suspend fun getCharacterFromList(): DisneyCharacterModel
}