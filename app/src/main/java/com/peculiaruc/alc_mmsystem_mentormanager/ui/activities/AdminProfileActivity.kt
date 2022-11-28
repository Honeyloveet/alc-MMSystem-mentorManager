package com.peculiaruc.alc_mmsystem_mentormanager.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ActivityAdminProfileBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.viewmodels.AdminProfileViewModel

class AdminProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminProfileBinding

    private lateinit var viewModel: AdminProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[AdminProfileViewModel::class.java]

        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        Glide.with(this).load("https://images.unsplash.com/photo-1632765854612-9b02b6ec2b15?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1886&q=80")
            .circleCrop()
            .placeholder(R.drawable.ic_user_avater)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.imageViewProfileImg)

    }
}