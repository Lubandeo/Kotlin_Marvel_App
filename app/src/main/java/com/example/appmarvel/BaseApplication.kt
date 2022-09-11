package com.example.appmarvel

import android.app.Application
import com.example.appmarvel.di.ModelModule.modelModule
import com.example.appmarvel.di.ServiceModule.serviceModule
import com.example.appmarvel.di.UseCaseModule.useCaseModule
import com.example.appmarvel.di.ViewModelModule.viewModelModule
import com.example.appmarvel.di.ApiModule.apiModule

import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class BaseApplication : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    viewModelModule,
                    modelModule,
                    useCaseModule,
                    serviceModule,
                    apiModule
                )
            )
        }
    }
}
