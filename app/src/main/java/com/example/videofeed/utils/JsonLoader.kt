package com.example.videofeed.utils

import android.content.Context
import java.io.IOException
import java.io.InputStream

object JsonLoader {
    public fun loadJson(context: Context, fileName: String): String {
        val jsonString: String
        try {
            val stream: InputStream = context.assets.open(fileName)
            val size: Int = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            jsonString = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
            return null.toString()
        }

        return jsonString
    }
}