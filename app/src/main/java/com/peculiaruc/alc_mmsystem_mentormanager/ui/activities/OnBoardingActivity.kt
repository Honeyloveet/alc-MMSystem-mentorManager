package com.peculiaruc.alc_mmsystem_mentormanager.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ActivityOnboardingBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.OnBoardingAdapter

/**
 * This activity is for onboarding screens
 */
class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding
    private lateinit var adapter: OnBoardingAdapter
    private var imagesList = mutableListOf<Int>()
    private var messagesList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populateLists()

        adapter = OnBoardingAdapter(messagesList, imagesList)
        binding.onBoardingViewPager.adapter = adapter

        adapter.setOnItemClickListener(object : OnBoardingAdapter.OnItemClickListener {
            override fun onNextClick(position: Int) {
                if (position != 2) {
                    binding.onBoardingViewPager.setCurrentItem(position + 1, true)
                } else {
                    val intent = Intent(this@OnBoardingActivity, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }

            override fun onPreviousClick(position: Int) {
                binding.onBoardingViewPager.setCurrentItem(position - 1, true)
            }
        })

        binding.onBoardingViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                changeIndicatorColor()
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                changeIndicatorColor()
            }

        })
    }

    private fun changeIndicatorColor() {
        when (binding.onBoardingViewPager.currentItem) {
            0 -> {
                binding.indicator1.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.mms_pry_2))
                binding.indicator2.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.mms_black_8))
                binding.indicator3.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.mms_black_8))
            }
            1 -> {
                binding.indicator1.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.mms_black_8))
                binding.indicator2.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.mms_pry_2))
                binding.indicator3.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.mms_black_8))
            }
            2 -> {
                binding.indicator1.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.mms_black_8))
                binding.indicator2.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.mms_black_8))
                binding.indicator3.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.mms_pry_2))
            }
        }
    }

    private fun populateLists() {
        val messages = resources.getStringArray(R.array.messages)

        imagesList.add(R.drawable.onboarding_image_1)
        imagesList.add(R.drawable.onboarding_image_2)
        imagesList.add(R.drawable.onboarding_image_3)

        for (message in messages) {
            messagesList.add(message)
        }
    }
}