package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.DocumentDto
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentProfileBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.DocumentsAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.DocumentsProfileAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.viewmodels.ProfileViewModel

class ProfileFragment : Fragment() {

    private lateinit var viewModel: ProfileViewModel
    var binding: FragmentProfileBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        Glide.with(this).load(R.mipmap.ic_launcher)
            .circleCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding!!.imageViewProfileImg)

        val fakeDocs = listOf(
            DocumentDto(1, "Myresume.pdf"),
            DocumentDto(2, "my certificate.doc"),
            DocumentDto(3, "certificate2.doc"),
        )

        val documentsProfileAdapter = DocumentsProfileAdapter {

        }

        binding?.recyclerViewDocuments?.adapter = documentsProfileAdapter

        documentsProfileAdapter.submitList(fakeDocs)

        binding?.buttonEditProfile?.setOnClickListener {
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToEditProfileFragment())
        }

        binding?.topbar?.imageViewBack?.setOnClickListener {
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToRegisterFormFourFragment())
        }

        return binding?.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}