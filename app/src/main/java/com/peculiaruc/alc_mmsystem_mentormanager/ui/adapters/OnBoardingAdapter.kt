package com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.OnboardingLayoutBinding

class OnBoardingAdapter(private val messages: List<String>, private val images: List<Int>) : RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private lateinit var clickListener : OnItemClickListener

    interface OnItemClickListener {
        fun onNextClick(position: Int, btnText: String)
        fun onPreviousClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        clickListener = listener
    }

    inner class OnBoardingViewHolder(val binding: OnboardingLayoutBinding, listener: OnItemClickListener) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.apply {
                btnNext.setOnClickListener {
                    listener.onNextClick(adapterPosition, btnNext.text.toString())
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
                    btnPrevious.visibility = View.INVISIBLE
                    btnNext.setText(R.string.onboard_btn_next)
                    onBoardingTextVIew.text = messages[position]
                }
                1 -> {
                    btnPrevious.visibility = View.VISIBLE
                    btnNext.setText(R.string.onboard_btn_next)
                    onBoardingTextVIew.text = messages[position]
                }
                2 -> {
                    btnPrevious.visibility = View.VISIBLE
                    btnNext.setText(R.string.onboard_btn_finish)
                    onBoardingTextVIew.text = messages[position]
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return messages.size
    }

}