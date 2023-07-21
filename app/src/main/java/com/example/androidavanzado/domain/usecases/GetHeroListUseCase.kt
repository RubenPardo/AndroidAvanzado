package com.example.androidavanzado.domain.usecases

import com.example.androidavanzado.Model
import kotlinx.coroutines.delay

class GetHeroListUseCase {
    suspend operator fun invoke(): List<Model> {
        delay(1000)
        return List<Model>(10){ Model.dummy() }
    }
}