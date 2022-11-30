package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentNewTaskDialogBinding

/**
 * its a bottom sheet dialog for New task created successfully.
 */
class NewTaskDialogFragment(private val buttonDoneClickListener: (Boolean) -> Unit) : BottomSheetDialogFragment() {

    private var _binding: FragmentNewTaskDialogBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentNewTaskDialogBinding.inflate(inflater, container, false)

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