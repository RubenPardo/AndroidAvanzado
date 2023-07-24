package com.example.androidavanzado.di

import com.example.androidavanzado.domain.usecases.GetHeroListUseCase
import org.koin.dsl.module


val useCasesModule = module {
    factory <GetHeroListUseCase>{GetHeroListUseCase()}
}