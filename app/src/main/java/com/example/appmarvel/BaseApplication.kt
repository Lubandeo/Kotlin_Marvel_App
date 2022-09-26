package com.example.appmarvel

import android.app.Application
import com.example.appmarvel.di.ApiModule.apiModule
import com.example.appmarvel.di.DBModule.dbModule
import com.example.appmarvel.di.ModelModule.modelModule
import com.example.appmarvel.di.RepositoryModule.repositoryModule
import com.example.appmarvel.di.ServiceModule.serviceModule
import com.example.appmarvel.di.UseCaseModule.useCaseModule
import com.example.appmarvel.di.ViewModelModule.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class BaseApplication : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BaseApplication)
            modules(
                listOf(
                    viewModelModule,
                    modelModule,
                    useCaseModule,
                    serviceModule,
                    apiModule,
                    dbModule,
                    repositoryModule
                )
            )
        }
    }
}
