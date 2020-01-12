package com.noon.assignment.app

import android.app.Application
import com.noon.assignment.api.ApiModule
import com.noon.assignment.database.DatabaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ActivityBuilder::class,
    AppModule::class, ApiModule::class, DatabaseModule::class])
interface AppComponent {

    fun inject(app: MoviesApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
