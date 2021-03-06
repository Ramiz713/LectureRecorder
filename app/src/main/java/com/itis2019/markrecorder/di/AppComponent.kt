package com.itis2019.markrecorder.di

import android.app.Application
import com.itis2019.markrecorder.App
import com.itis2019.markrecorder.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        RoomModule::class,
        ViewModelModule::class,
        RepositoryModule::class,
        RouterModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: App)
}
