package com.tana.sportassist.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tana.sportassist.data.remote.SportAssistApi
import com.tana.sportassist.utils.SportAssistConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SportAssistModule {

    @Provides
    @Singleton
    fun provideApi(): SportAssistApi =
        Retrofit.Builder()
            .baseUrl(SportAssistConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SportAssistApi::class.java)

}