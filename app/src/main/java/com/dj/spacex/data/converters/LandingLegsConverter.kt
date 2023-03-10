package com.dj.spacex.data.converters

import androidx.room.TypeConverter
import com.dj.spacex.data.rocket.model.LandingLegs
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LandingLegsConverter {
    private val gson = Gson()
    private val type = object : TypeToken<LandingLegs>() {}.type

    @TypeConverter
    fun landingLegsToString(landingLegs: LandingLegs): String? {
        return gson.toJson(landingLegs, type)
    }

    @TypeConverter
    fun stringToLandingLegs(string: String): LandingLegs? {
        return gson.fromJson(string, type)
    }
}