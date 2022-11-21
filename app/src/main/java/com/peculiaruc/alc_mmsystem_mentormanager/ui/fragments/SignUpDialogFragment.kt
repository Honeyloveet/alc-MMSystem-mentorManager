package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentSignUpDialogBinding

class SignUpDialogFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentSignUpDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSignUpDialogBinding.inflate(inflater, container, false)

        binding.buttonDone.setOnClickListener {
            dismiss()
        }



        // Inflate the layout for this fragment
        return binding.root
    }
}