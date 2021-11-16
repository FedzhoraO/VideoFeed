package com.example.videofeed.utils

import java.lang.reflect.Type
import com.google.gson.Gson

object GsonHelper {
    private val gson = Gson()

    public fun parseJson(json: String, type: Type):Any {
        return gson.fromJson(json, type)
    }
}