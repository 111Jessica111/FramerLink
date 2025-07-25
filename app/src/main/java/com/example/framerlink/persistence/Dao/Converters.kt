package com.example.framerlink.persistence.Dao

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromStringList(value: String?): List<String?>? {
        val type = object : TypeToken<List<String?>>(){}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun toStringList(list: List<String?>?): String?{
        return gson.toJson(list)
    }
}