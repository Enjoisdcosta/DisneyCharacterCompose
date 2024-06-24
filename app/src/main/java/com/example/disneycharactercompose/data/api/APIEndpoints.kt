package com.example.disneycharactercompose.data.api

import com.example.disneycharactercompose.data.model.DataModel
import com.example.disneycharactercompose.data.model.DisneyCharacterModel
import retrofit2.http.GET

interface APIEndpoints {

//    @GET(APIDetails.CHARACTER_ENDPOINT)
//    suspend fun getCharacterList(): List<DataModel>

    @GET(APIDetails.CHARACTER_ENDPOINT)
    suspend fun getCharacterFromList(): DisneyCharacterModel




}