package com.example.disneycharactercompose.data.repository

import com.example.disneycharactercompose.data.api.APIEndpoints
import com.example.disneycharactercompose.data.model.DataModel
import com.example.disneycharactercompose.data.model.DisneyCharacterModel
import javax.inject.Inject

class DisneyCharacterRepositoryImpementaion @Inject constructor(
    private val apiDetail: APIEndpoints
): DisneyCharacterRepository {
    override suspend fun getCharacterList(): List<DataModel> {
        return apiDetail.getCharacterList()
    }

    override suspend fun getCharacterFromList(): List<DisneyCharacterModel> {
        return apiDetail.getCharacterFromList()
    }
}