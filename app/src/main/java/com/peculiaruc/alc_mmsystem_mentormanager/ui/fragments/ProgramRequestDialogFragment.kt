package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentProgramRequestDialogBinding

/**
 * its a bottom sheet dialog for Program join request sent successfully message.
 */
class ProgramRequestDialogFragment(private val buttonDoneClickListener: (Boolean) -> Unit) : BottomSheetDialogFragment() {

    private var _binding: FragmentProgramRequestDialogBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentProgramRequestDialogBinding.inflate(inflater, container, false)

        binding.buttonDone.setOnClickListener {
            buttonDoneClickListener(true)
            dismiss()
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}