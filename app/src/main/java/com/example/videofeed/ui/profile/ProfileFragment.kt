package com.example.videofeed.ui.profile

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.videofeed.R
import com.example.videofeed.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel
    private var _binding: FragmentProfileBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        (activity as AppCompatActivity).supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        (activity as AppCompatActivity).supportActionBar?.setCustomView(R.layout.actionbar_user_name)
        val userNameTitle =
            (activity as AppCompatActivity).supportActionBar?.customView?.findViewById<AppCompatTextView>(
                R.id.tvUserName
            )
        profileViewModel.user.observe(viewLifecycleOwner, {
            userNameTitle?.text = it.userTitle
            binding.userTag.text = it.userName
            binding.userVideos.text =
                """${it.userVideos} ${resources.getQuantityText(R.plurals.videos, it.userVideos)}"""
            binding.followingsText.text = resources.getQuantityText(R.plurals.followings, it.userFollowing)
            binding.heartsText.text = resources.getQuantityText(R.plurals.hearts, it.userHearts)
            binding.fansText.text = resources.getQuantityText(R.plurals.fans, it.userFans)
            binding.userFollowings.text = it.userFollowing.toString()
            binding.userFans.text = it.userFans.toString()
            binding.userHearts.text = it.userHearts.toString()
            binding.userBio.text = getString(R.string.no_bio)
            Glide
                .with(this)
                .load(Uri.parse("file:///android_asset/${it.userLocalImage}.png"))
                .circleCrop()
                .into(binding.userImage)
        })
        profileViewModel.getUserData(requireContext())
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}