package com.peculiaruc.alc_mmsystem_mentormanager.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ActivityRegistrFormBinding

class RegisterFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrFormBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}