package com.dj.spacex.data.converters

import androidx.room.TypeConverter
import com.dj.spacex.data.rocket.model.FirstStage
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class FirstStageConverter {
    private val gson = Gson()
    private val type = object : TypeToken<FirstStage>() {}.type

    @TypeConverter
    fun firstStageToString(firstStage: FirstStage): String? {
        return gson.toJson(firstStage, type)
    }

    @TypeConverter
    fun stringToFirstStage(string: String): FirstStage? {
        return gson.fromJson(string, type)
    }
}