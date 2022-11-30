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

/**
 * this fragment is used to show the list of programs
 */
class ProgramsFragment : Fragment() {

    var binding: FragmentProgramsBinding? = null

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProgramsBinding.inflate(layoutInflater)

        val tempImage1 = "https://images.unsplash.com/photo-1633356122544-f134324a6cee?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"
        val tempImage2 = "https://images.unsplash.com/photo-1611162617213-7d7a39e9b1d7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80"
        val tempImage3 = "https://images.unsplash.com/photo-1493612276216-ee3925520721?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=464&q=80"

        val allProgramsFakes =  listOf(ProgramDto(1,"Google Africa Scholarship Program 1",tempImage1),
                                        ProgramDto(2,"Google Africa Scholarship Program 2",tempImage2),
                                        ProgramDto(3,"Google Africa Scholarship Program 3",tempImage3),
                                        ProgramDto(4,"Google Africa Scholarship Program 4",tempImage1),
                                        ProgramDto(5,"Google Africa Scholarship Program 5",tempImage2),
                                        ProgramDto(6,"Google Africa Scholarship Program 6",tempImage3),
                                        ProgramDto(7,"Google Africa Scholarship Program 7",tempImage1),
                                        ProgramDto(8,"Google Africa Scholarship Program 8",tempImage2),
                                        ProgramDto(9,"Google Africa Scholarship Program 9",tempImage3),
                                        ProgramDto(10,"Google Africa Scholarship Program 10",tempImage1),
        )

        val assignedFakes =  listOf(ProgramDto(6,"Google Africa Scholarship Program 11",tempImage1),
                                        ProgramDto(7,"Google Africa Scholarship Program 12",tempImage2),
                                        ProgramDto(8,"Google Africa Scholarship Program 13",tempImage3),
        )

        val completedFakes =  listOf(ProgramDto(10,"Google Africa Scholarship Program 14",tempImage1),
                                        ProgramDto(11,"Google Africa Scholarship Program 15",tempImage2),
                                        ProgramDto(12,"Google Africa Scholarship Program 16",tempImage3),
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