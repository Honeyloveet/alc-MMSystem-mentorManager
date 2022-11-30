package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentProgramDetailsBinding

/**
 * this fragment is used to show the details of a specific program
 */
class ProgramDetailsFragment : Fragment() {

    private var _binding: FragmentProgramDetailsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentProgramDetailsBinding.inflate(inflater, container, false)

        Glide.with(this).load("https://images.unsplash.com/photo-1633356122544-f134324a6cee?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80")
            .circleCrop()
            .placeholder(R.drawable.profile_circle)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.imageViewProgram)

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigate(ProgramDetailsFragmentDirections.actionProgramDetailsFragmentToProgramsFragment())
        }

        binding.buttonJoinProgram.setOnClickListener {
            findNavController().navigate(ProgramDetailsFragmentDirections.actionProgramDetailsFragmentToProgramCriteriaFormFragment())
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}