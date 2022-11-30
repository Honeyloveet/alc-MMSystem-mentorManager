package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.DocumentDto
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentRegisterFormFourBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.activities.MainActivity
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.DocumentsAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.viewmodels.RegisterFormFourViewModel

/**
 * this fragment is used to fill form four when registering
 * for the first time to be a Mentor Manager
 */
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

        binding?.buttonNext?.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}