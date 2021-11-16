package com.example.videofeed.ui.profile

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.videofeed.utils.JsonLoader
import com.example.videofeed.models.User
import com.example.videofeed.utils.GsonHelper

import com.google.gson.reflect.TypeToken


class ProfileViewModel : ViewModel() {

    private val fileName = "user.json"
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    public fun getUserData(context: Context) {
        val jsonString = JsonLoader.loadJson(context, fileName)
        val type = object : TypeToken<User>() {}.type
        _user.value = GsonHelper.parseJson(jsonString, type) as User
    }
}