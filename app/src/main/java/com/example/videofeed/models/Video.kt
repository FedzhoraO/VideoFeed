package com.example.videofeed.models

import com.google.gson.annotations.SerializedName

data class Video(
    @SerializedName("video_description") val videoDescription: String,
    @SerializedName("video_path") val videoPath: String,
    @SerializedName("video_number_likes") val videoNumberLikes: Int,
    @SerializedName("video_number_comments") val videoNumberComments: Int,
    @SerializedName("user_id") val userId: String,
    @SerializedName("user_name") val userName: String,
    @SerializedName("user_image_path") val userImagePath: String
)
