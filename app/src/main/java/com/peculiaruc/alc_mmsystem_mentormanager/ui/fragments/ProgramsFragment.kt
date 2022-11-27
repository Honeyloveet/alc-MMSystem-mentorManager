package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
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

        val allProgramsFakes =  listOf(ProgramDto(1,"Google Africa Scholarship Program"),
                                        ProgramDto(2,"Google Africa Scholarship Program"),
                                        ProgramDto(3,"Google Africa Scholarship Program"),
                                        ProgramDto(4,"Google Africa Scholarship Program"),
                                        ProgramDto(5,"Google Africa Scholarship Program"),)

        val assignedFakes =  listOf(ProgramDto(6,"Google Africa Scholarship Program 2"),
                                        ProgramDto(7,"Google Africa Scholarship Program 2"),
                                        ProgramDto(8,"Google Africa Scholarship Program 2"),)

        val completedFakes =  listOf(ProgramDto(10,"Google Africa Scholarship Program 3"),
                                        ProgramDto(11,"Google Africa Scholarship Program 3"),
                                        ProgramDto(12,"Google Africa Scholarship Program 3"),)

        val programAdapter = ProgramAdapter{ }
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