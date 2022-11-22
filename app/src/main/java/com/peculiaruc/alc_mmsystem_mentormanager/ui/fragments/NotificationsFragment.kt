package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.NotificationDto
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentNotificationsBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.NotificationsAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.viewmodels.NotificationsViewModel

class NotificationsFragment : Fragment() {

    private lateinit var viewModel: NotificationsViewModel

    var binding: FragmentNotificationsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationsBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[NotificationsViewModel::class.java]

        val fakeNotification = listOf(
            NotificationDto(1, "MyResume.pdf"),
            NotificationDto(2, "my certificate.doc"),
            NotificationDto(3, "my certificate2.doc"),
        )
        val notificationsAdapter  = NotificationsAdapter {

        }
        binding?.recyclerViewNotifications?.adapter = notificationsAdapter
        notificationsAdapter.submitList(fakeNotification)

        binding?.imageViewProfileImg?.setOnClickListener {
            findNavController().navigate(NotificationsFragmentDirections.actionNotificationsFragmentToProfileFragment())
        }

        Glide.with(this).load("https://images.unsplash.com/photo-1632765854612-9b02b6ec2b15?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1886&q=80")
            .circleCrop()
            .placeholder(R.drawable.ic_user_avater)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding!!.imageViewProfileImg)

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}