package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.chip.Chip
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.DocumentDto
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.RoleDto
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentProgramCriteriaFormBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.DocumentsAdapter

class ProgramCriteriaFormFragment : Fragment() {

    private var _binding: FragmentProgramCriteriaFormBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentProgramCriteriaFormBinding.inflate(inflater, container, false)

        val fakeDocs = listOf(
            DocumentDto(1, "recommendation 1.pdf"),
            DocumentDto(2, "recommendation 2.pdf")
        )

        val documentAdapter = DocumentsAdapter {

        }

        binding.recyclerViewDocuments.adapter = documentAdapter

        documentAdapter.submitList(fakeDocs)

        val chipsRoles = listOf(
            RoleDto(1,"Learner"), RoleDto(2,"Mentor"), RoleDto(3,"Program Assistant")
        )

        chipsRoles.forEach {
            val chip = layoutInflater.inflate(R.layout.custom_chip_choice, binding.chipGroupPreviousRolesHeld, false) as Chip
            chip.text = it.name

            binding.chipGroupPreviousRolesHeld.addView(chip)
        }

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigate(ProgramCriteriaFormFragmentDirections.actionProgramCriteriaFormFragmentToProgramDetailsFragment())
        }

        binding.buttonSubmit.setOnClickListener {
            ProgramRequestDialogFragment{
                findNavController().navigate(ProgramCriteriaFormFragmentDirections.actionProgramCriteriaFormFragmentToProgramDetailsFragment())
            }.show(parentFragmentManager, "programRequestDialog")
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}