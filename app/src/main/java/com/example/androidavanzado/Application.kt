package com.example.androidavanzado

import android.app.Application
import com.example.androidavanzado.di.useCasesModule
import com.example.androidavanzado.di.viewModelModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger(if(BuildConfig.DEBUG) Level.INFO else Level.NONE)
            androidContext(this@Application)
            modules(listOf(
                viewModelModule,
                useCasesModule
            ))
        }
    }

}