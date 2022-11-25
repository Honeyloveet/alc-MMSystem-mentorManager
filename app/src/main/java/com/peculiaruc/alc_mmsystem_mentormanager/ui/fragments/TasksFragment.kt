package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentTasksBinding

class TasksFragment : Fragment() {

    private lateinit var binding: FragmentTasksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTasksBinding.inflate(layoutInflater)

        binding.topbar.textViewHeadline.text = "Tasks"

        changeFilterControlsView("All")

        binding.chipAllTask.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                changeFilterControlsView("All")
            }
        }

        binding.chipAssignedTask.setOnCheckedChangeListener { _ , isChecked ->
            if (isChecked) {
                changeFilterControlsView("Assigned")
            }
        }

        binding.chipCompletedTask.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                changeFilterControlsView("Completed")
            }
        }

        binding.chipMyTasks.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                changeFilterControlsView("MyTasks")
            }
        }

        binding.topbar.imageViewBack.setOnClickListener {
            activity?.finish()
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun changeFilterControlsView(selected: String) {
        when (selected) {
            "All" -> {
                binding.chipAllTask.textSize = 16f
                binding.chipAssignedTask.textSize = 12f
                binding.chipCompletedTask.textSize = 12f
                binding.chipMyTasks.textSize = 12f
            }
            "Assigned" -> {
                binding.chipAllTask.textSize = 12f
                binding.chipAssignedTask.textSize = 16f
                binding.chipCompletedTask.textSize = 12f
                binding.chipMyTasks.textSize = 12f
            }
            "Completed" -> {
                binding.chipAllTask.textSize = 12f
                binding.chipAssignedTask.textSize = 12f
                binding.chipCompletedTask.textSize = 16f
                binding.chipMyTasks.textSize = 12f
            }
            "MyTasks" -> {
                binding.chipAllTask.textSize = 12f
                binding.chipAssignedTask.textSize = 12f
                binding.chipCompletedTask.textSize = 12f
                binding.chipMyTasks.textSize = 16f
            }
        }
    }

}