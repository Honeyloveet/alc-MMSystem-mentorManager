package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentTaskDetailsBinding

class TaskDetailsFragment : Fragment() {

    private var _binding: FragmentTaskDetailsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTaskDetailsBinding.inflate(inflater, container, false)

        val activityTask = activity as AppCompatActivity

        activityTask.setSupportActionBar(binding.toolbar)

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        binding.buttonViewMentors.setOnClickListener {
            findNavController().navigate(TaskDetailsFragmentDirections.actionTaskDetailsFragmentToTaskAssignedMentorsFragment())
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}