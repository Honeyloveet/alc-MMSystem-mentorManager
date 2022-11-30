package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.content.Intent
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
import com.peculiaruc.alc_mmsystem_mentormanager.ui.activities.TempEntryActivity
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.NotificationsAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.viewmodels.NotificationsViewModel

/**
 * this fragment is used to notify the
 * mentor manager applicant the status of
 * his application to become a Mentor Manager
 */
class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: NotificationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[NotificationsViewModel::class.java]

        val fakeNotification = listOf(
            NotificationDto(1, "MyResume.pdf"),
            NotificationDto(2, "my certificate.doc"),
        )
        val notificationsAdapter  = NotificationsAdapter {

        }
        binding.recyclerViewNotifications.adapter = notificationsAdapter
        notificationsAdapter.submitList(fakeNotification)

        binding.imageViewProfileImg.setOnClickListener {
            findNavController().navigate(NotificationsFragmentDirections.actionNotificationsFragmentToProfileFragment())
        }

        binding.buttonContinue.setOnClickListener {
            val intent = Intent(activity, TempEntryActivity::class.java)
            startActivity(intent)
        }

        Glide.with(this).load("https://images.unsplash.com/photo-1632765854612-9b02b6ec2b15?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1886&q=80")
            .circleCrop()
            .placeholder(R.drawable.ic_user_avater)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.imageViewProfileImg)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}