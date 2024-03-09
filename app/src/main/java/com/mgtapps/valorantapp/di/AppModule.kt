package com.mgtapps.valorantapp.di

import com.mgtapps.valorantapp.data.remote.ValorantApi
import com.mgtapps.valorantapp.data.repository.ValorantValorantRepositoryImpl
import com.mgtapps.valorantapp.domain.ValorantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://valorant-api.com/v1/agents/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): ValorantApi {
        return retrofit.create(ValorantApi::class.java)
    }


    @Provides
    @Singleton
    fun repository(api: ValorantApi): ValorantRepository {
        return ValorantValorantRepositoryImpl(api)
    }
}