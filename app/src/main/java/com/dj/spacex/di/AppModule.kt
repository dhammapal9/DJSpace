package com.dj.spacex.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.datastore.core.DataStore
import androidx.datastore.createDataStore
import androidx.datastore.preferences.createDataStore
import androidx.preference.PreferenceManager
import androidx.room.Room
import com.dj.spacex.data.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ActivityBuildersModule::class, ViewModelModule::class])
class AppModule {
    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun providesRoomDB(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "db").allowMainThreadQueries()
            .fallbackToDestructiveMigration().build()
    }



    @Singleton
    @Provides
    fun provideRocketDao(appDatabase: AppDatabase) = appDatabase.rocketDao()







    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)


    @Singleton
    @Provides
    fun provideDataStore(context: Context): DataStore<androidx.datastore.preferences.core.Preferences> {
        return context.createDataStore(
            name = "dataStore"
        )
    }
}