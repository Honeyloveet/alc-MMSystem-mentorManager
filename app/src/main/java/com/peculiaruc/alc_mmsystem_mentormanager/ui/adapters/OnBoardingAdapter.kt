package com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.OnboardingLayoutBinding

class OnBoardingAdapter(private val messages: List<String>, private val images: List<Int>) : RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private lateinit var clickListener : OnItemClickListener

    interface OnItemClickListener {
        fun onNextClick(position: Int)
        fun onPreviousClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        clickListener = listener
    }

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