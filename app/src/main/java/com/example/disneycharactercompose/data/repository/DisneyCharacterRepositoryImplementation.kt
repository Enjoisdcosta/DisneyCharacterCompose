package com.example.disneycharactercompose.data.repository

import com.example.disneycharactercompose.data.api.APIEndpoints
import com.example.disneycharactercompose.data.model.DataModel
import com.example.disneycharactercompose.data.model.DisneyCharacterModel
import javax.inject.Inject

class DisneyCharacterRepositoryImplementation @Inject constructor(
    private val apiDetail: APIEndpoints
): DisneyCharacterRepository {

    override suspend fun getCharacterFromList(): DisneyCharacterModel {
        return apiDetail.getCharacterFromList()
    }


}