package com.example.disneycharactercompose.di

import com.example.disneycharactercompose.data.api.APIDetails.BASE_URL
import com.example.disneycharactercompose.data.api.APIEndpoints
import com.example.disneycharactercompose.data.repository.DisneyCharacterRepository
import com.example.disneycharactercompose.data.repository.DisneyCharacterRepositoryImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideCartApiService(retrofit: Retrofit): APIEndpoints {
        return retrofit.create(APIEndpoints::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(apiEndpoints: APIEndpoints ): DisneyCharacterRepository{
        return DisneyCharacterRepositoryImplementation(apiEndpoints)
    }
}