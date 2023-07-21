package com.example.androidavanzado.di

import com.example.androidavanzado.domain.usecases.GetHeroListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {


    @Provides
    fun provideGetHeroListUseCase():GetHeroListUseCase{
        return GetHeroListUseCase()
    }

}