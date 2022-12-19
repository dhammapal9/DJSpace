package com.dj.spacex.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dj.spacex.data.converters.*
import com.dj.spacex.data.rocket.RocketDao
import com.dj.spacex.data.rocket.model.Rocket


@Database(entities = [ Rocket::class],
    version = 1,
    exportSchema = false)
@TypeConverters(
    JsonToStringConverter::class,
    PayloadWeightTypeConverter::class,
    DiameterConverter::class,
    FirstStageConverter::class,
    EnginesConverter::class,
    HeightConverter::class,
    LandingLegsConverter::class,
    SecondStageConverter::class,
    MassConverter::class
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun rocketDao(): RocketDao
}