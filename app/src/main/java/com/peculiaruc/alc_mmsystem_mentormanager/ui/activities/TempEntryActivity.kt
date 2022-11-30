package com.peculiaruc.alc_mmsystem_mentormanager.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ActivityTempEnteryBinding

/**
 * Temporary entry point activity for programs, tasks
 * and admin profile screen
 * this is a temporary activity it should be removed
 * when merging.
 */
class TempEntryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTempEnteryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTempEnteryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonAdminProfile.setOnClickListener {
            val intent = Intent(this, AdminProfileActivity::class.java)
            startActivity(intent)
        }

        binding.buttonTasks.setOnClickListener {
            val intent = Intent(this, TasksActivity::class.java)
            startActivity(intent)
        }

        binding.buttonPrograms.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        binding.buttonBack.setOnClickListener {
            onBackPressed()
        }
    }
}