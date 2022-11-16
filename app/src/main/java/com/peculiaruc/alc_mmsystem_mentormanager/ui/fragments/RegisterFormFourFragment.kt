package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.DocumentDto
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentRegisterFormFourBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentRegisterFormThreeBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.DocumentsAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.viewmodels.RegisterFormFourViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.ui.viewmodels.RegisterFormThreeViewModel

class RegisterFormFourFragment : Fragment() {

    private lateinit var viewModel: RegisterFormFourViewModel

    var binding: FragmentRegisterFormFourBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterFormFourBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[RegisterFormFourViewModel::class.java]

        val fakeDocs = listOf(
            DocumentDto(1, "Myresume.pdf"),
            DocumentDto(2, "my certificate.doc"),
            DocumentDto(3, "my certificate2.doc"),
        )
        val documentAdapter = DocumentsAdapter {

        }
        binding?.recyclerViewDocuments?.adapter = documentAdapter
        documentAdapter.submitList(fakeDocs)

        binding?.buttonPrevious?.setOnClickListener {
            findNavController().navigate(RegisterFormFourFragmentDirections.actionRegisterFormFourFragmentToRegisterFormThreeFragment())
        }

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}