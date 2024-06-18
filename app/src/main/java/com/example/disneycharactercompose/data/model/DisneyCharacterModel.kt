package com.example.disneycharactercompose.data.model


import com.google.gson.annotations.SerializedName

data class DisneyCharacterModel(
    @SerializedName("data")
    val `data`: List<DataModel?>? = listOf(),
    @SerializedName("info")
    val info: InfoModel? = InfoModel()
)