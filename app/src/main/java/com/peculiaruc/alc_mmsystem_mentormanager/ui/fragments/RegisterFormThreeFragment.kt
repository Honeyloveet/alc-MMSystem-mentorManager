package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.chip.Chip
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.ChipDto
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.RoleDto
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentRegisterFormThreeBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.viewmodels.RegisterFormThreeViewModel

class RegisterFormThreeFragment : Fragment() {

    private lateinit var viewModel: RegisterFormThreeViewModel

    var binding: FragmentRegisterFormThreeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterFormThreeBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[RegisterFormThreeViewModel::class.java]

        binding?.buttonPrevious?.setOnClickListener {
            findNavController().navigate(RegisterFormThreeFragmentDirections.actionRegisterFormThreeFragmentToRegisterFormTwoFragment())
        }

        binding?.buttonNext?.setOnClickListener {
            findNavController().navigate(RegisterFormThreeFragmentDirections.actionRegisterFormThreeFragmentToRegisterFormFourFragment())
        }

        val chipsTechnicality = listOf(ChipDto(1,"Python"),ChipDto(2,"Java"), ChipDto(3,"Kotlin"),
                                    ChipDto(4,"Django"),ChipDto(5,"JavaScript"), ChipDto(6,"My SQL"),
                                    ChipDto(6,"Android"),ChipDto(6,"Swift"),ChipDto(6,"C++"),)

        val chipsRules = listOf(RoleDto(1,"Learner"),RoleDto(2,"Mentor"), RoleDto(3,"Program Assistant"),
                                RoleDto(4,"Program Assistant Lead"),RoleDto(5,"Mentor Manager"),)
        chipsTechnicality.forEach {
            val chip = layoutInflater.inflate(R.layout.custom_chip_choice, binding?.chipGroupTechnicalProficiency, false) as Chip
            chip.text = it.name

            binding?.chipGroupTechnicalProficiency?.addView(chip)
        }

        chipsRules.forEach {
            val chip = layoutInflater.inflate(R.layout.custom_chip_choice, binding?.chipGroupTechnicalProficiency, false) as Chip
            chip.text = it.name

            binding?.chipGroupPreviousRolesHeld?.addView(chip)
        }

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}