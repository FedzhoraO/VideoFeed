package com.example.videofeed.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.videofeed.models.User
import com.example.videofeed.models.Video
import com.example.videofeed.utils.GsonHelper
import com.example.videofeed.utils.JsonLoader
import com.google.gson.reflect.TypeToken

class HomeViewModel : ViewModel() {

    private val fileName = "videos.json"

    private val _videos = MutableLiveData<List<Video>>()
    val videos: LiveData<List<Video>> = _videos

    public fun getUserData(context: Context) {
        val jsonString = JsonLoader.loadJson(context, fileName)
        val type = object : TypeToken<List<Video>>() {}.type
        _videos.value = GsonHelper.parseJson(jsonString, type) as List<Video>
    }
}