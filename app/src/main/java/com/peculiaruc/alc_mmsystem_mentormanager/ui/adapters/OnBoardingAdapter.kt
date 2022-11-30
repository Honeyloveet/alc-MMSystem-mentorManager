package com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.OnboardingLayoutBinding

/**
 * An adapter for onboarding layout screen for viewpager
 */
class OnBoardingAdapter(private val messages: List<String>, private val images: List<Int>) : RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private lateinit var clickListener : OnItemClickListener

    /**
     * An interface which listens clicks
     * for [onNextClick] and [onPreviousClick] buttons
     */
    interface OnItemClickListener {
        /**
         * function for next button click listener
         * with position of the adapter
         */
        fun onNextClick(position: Int)
        /**
         * function for previous button click listener
         * with position of the adapter
         */
        fun onPreviousClick(position: Int)
    }

    /**
     * sets the click listener for [clickListener]
     */
    fun setOnItemClickListener(listener: OnItemClickListener) {
        clickListener = listener
    }

    /**
     * view holder class for [OnBoardingAdapter]
     */
    inner class OnBoardingViewHolder(val binding: OnboardingLayoutBinding, listener: OnItemClickListener) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.apply {
                btnNext.setOnClickListener {
                    listener.onNextClick(adapterPosition)
                }
                btnPrevious.setOnClickListener {
                    listener.onPreviousClick(adapterPosition)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(OnboardingLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ), clickListener)
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.binding.apply {
            when (position) {
                0 -> {
                    onBoardingImageView.setImageResource(images[position])
                    btnPrevious.visibility = View.INVISIBLE
                    onBoardingTextVIew.text = messages[position]
                }
                1 -> {
                    onBoardingImageView.setImageResource(images[position])
                    btnPrevious.visibility = View.VISIBLE
                    onBoardingTextVIew.text = messages[position]
                }
                2 -> {
                    onBoardingImageView.setImageResource(images[position])
                    btnPrevious.visibility = View.VISIBLE
                    onBoardingTextVIew.text = messages[position]
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return messages.size
    }

}