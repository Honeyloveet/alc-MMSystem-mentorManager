package com.peculiaruc.alc_mmsystem_mentormanager.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ActivitySetNewPasswordBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.SetNewPasswordDialogFragment

class SetNewPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySetNewPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetNewPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonReset.setOnClickListener {
            SetNewPasswordDialogFragment().show(supportFragmentManager, "setNewPassword")
        }

    }
}