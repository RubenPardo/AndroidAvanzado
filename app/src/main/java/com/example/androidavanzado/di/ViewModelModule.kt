package com.example.androidavanzado.di

import com.example.androidavanzado.domain.usecases.GetHeroListUseCase
import com.example.androidavanzado.presentation.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{ ListViewModel(get()) }
}