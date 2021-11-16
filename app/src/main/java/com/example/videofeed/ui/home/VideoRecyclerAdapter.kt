package com.example.videofeed.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.videofeed.databinding.VideoViewBinding
import com.example.videofeed.models.Video
import com.google.android.exoplayer2.ui.PlayerView
import java.util.ArrayList

class VideoRecyclerAdapter(
    val itemClickListener: ((PlayerView, String) -> Unit)?
) : RecyclerView.Adapter<VideoRecyclerAdapter.VideoViewHolder>() {

    var videos: List<Video> = ArrayList<Video>()

    public fun setItems(newVideos: List<Video>) {
        videos = newVideos
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding = VideoViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.onBind(videos[position])
    }

    override fun getItemCount() = videos.size

    inner class VideoViewHolder(val binding: VideoViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(videoObject: Video) {
            binding.videoTitle.text = videoObject.videoDescription
            binding.root.setOnClickListener {
                itemClickListener?.invoke(binding.playerView, videoObject.videoPath)
            }
        }
    }
}