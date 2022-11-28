package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.ProgramDto
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentProgramsBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.ProgramAdapter


class ProgramsFragment : Fragment() {

    var binding: FragmentProgramsBinding? = null

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProgramsBinding.inflate(layoutInflater)

        val allProgramsFakes =  listOf(ProgramDto(1,"Google Africa Scholarship Program","https://images.unsplash.com/photo-1633356122544-f134324a6cee?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"),
                                        ProgramDto(2,"Google Africa Scholarship Program","https://images.unsplash.com/photo-1611162617213-7d7a39e9b1d7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80"),
                                        ProgramDto(3,"Google Africa Scholarship Program","https://images.unsplash.com/photo-1493612276216-ee3925520721?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=464&q=80"),
                                        ProgramDto(4,"Google Africa Scholarship Program","https://images.unsplash.com/photo-1633356122544-f134324a6cee?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"),
                                        ProgramDto(5,"Google Africa Scholarship Program","https://images.unsplash.com/photo-1611162617213-7d7a39e9b1d7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80"),
                                        ProgramDto(6,"Google Africa Scholarship Program","https://images.unsplash.com/photo-1493612276216-ee3925520721?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=464&q=80"),
                                        ProgramDto(7,"Google Africa Scholarship Program","https://images.unsplash.com/photo-1633356122544-f134324a6cee?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"),
                                        ProgramDto(8,"Google Africa Scholarship Program","https://images.unsplash.com/photo-1611162617213-7d7a39e9b1d7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80"),
                                        ProgramDto(9,"Google Africa Scholarship Program","https://images.unsplash.com/photo-1493612276216-ee3925520721?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=464&q=80"),
                                        ProgramDto(10,"Google Africa Scholarship Program","https://images.unsplash.com/photo-1633356122544-f134324a6cee?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"),
        )

        val assignedFakes =  listOf(ProgramDto(6,"Google Africa Scholarship Program 2","https://images.unsplash.com/photo-1633356122544-f134324a6cee?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"),
                                        ProgramDto(7,"Google Africa Scholarship Program 2","https://images.unsplash.com/photo-1611162617213-7d7a39e9b1d7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80"),
                                        ProgramDto(8,"Google Africa Scholarship Program 2","https://images.unsplash.com/photo-1493612276216-ee3925520721?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=464&q=80"),
        )

        val completedFakes =  listOf(ProgramDto(10,"Google Africa Scholarship Program 3","https://images.unsplash.com/photo-1633356122544-f134324a6cee?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"),
                                        ProgramDto(11,"Google Africa Scholarship Program 3","https://images.unsplash.com/photo-1611162617213-7d7a39e9b1d7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80"),
                                        ProgramDto(12,"Google Africa Scholarship Program 3","https://images.unsplash.com/photo-1493612276216-ee3925520721?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=464&q=80"),
        )

        val programAdapter = ProgramAdapter(requireContext()){
            findNavController().navigate(ProgramsFragmentDirections.actionProgramsFragmentToProgramDetailsFragment())
        }

        binding?.recyclerViewPrograms?.adapter = programAdapter
        programAdapter.submitList(allProgramsFakes)

        binding?.buttonAssigned?.setOnClickListener {
            resetAllTabs()
            binding?.buttonAssigned?.backgroundTintList = resources.getColorStateList(R.color.white,null)
            binding?.buttonAssigned?.setTextColor( resources.getColorStateList(R.color.mms_pry_2,null))
            programAdapter.submitList(null)
            programAdapter.submitList(assignedFakes)
        }

        binding?.buttonCompleted?.setOnClickListener {
            resetAllTabs()
            binding?.buttonCompleted?.backgroundTintList = resources.getColorStateList(R.color.white,null)
            binding?.buttonCompleted?.setTextColor( resources.getColorStateList(R.color.mms_pry_2,null))
            programAdapter.submitList(null)
            programAdapter.submitList(completedFakes)
        }

        binding?.buttonAll?.setOnClickListener {
            resetAllTabs()
            binding?.buttonAll?.backgroundTintList = resources.getColorStateList(R.color.white,null)
            binding?.buttonAll?.setTextColor( resources.getColorStateList(R.color.mms_pry_2,null))
            programAdapter.submitList(null)
            programAdapter.submitList(allProgramsFakes)
        }

        binding?.toolbar?.setNavigationOnClickListener {
            activity?.finish()
        }

        return binding?.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun resetAllTabs() {
        binding?.buttonAll?.backgroundTintList = resources.getColorStateList(R.color.mms_pry_2,null)
        binding?.buttonAll?.setTextColor( resources.getColorStateList(R.color.white,null))

        binding?.buttonAssigned?.backgroundTintList = resources.getColorStateList(R.color.mms_pry_2,null)
        binding?.buttonAssigned?.setTextColor( resources.getColorStateList(R.color.white,null))

        binding?.buttonCompleted?.backgroundTintList = resources.getColorStateList(R.color.mms_pry_2,null)
        binding?.buttonCompleted?.setTextColor( resources.getColorStateList(R.color.white,null))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}