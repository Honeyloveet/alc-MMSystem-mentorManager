package com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Mentor
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ListMentorsBinding

class SelectMentorAdapter(private val context: Context) : RecyclerView.Adapter<SelectMentorAdapter.SelectMentorAdapterViewHolder>() {

    inner class SelectMentorAdapterViewHolder(val binding: ListMentorsBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    private val differCallback = object : DiffUtil.ItemCallback<Mentor>() {
        override fun areItemsTheSame(oldItem: Mentor, newItem: Mentor): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Mentor, newItem: Mentor): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectMentorAdapterViewHolder {
        return SelectMentorAdapterViewHolder(ListMentorsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: SelectMentorAdapterViewHolder, position: Int) {
        val mentor = differ.currentList[position]
        holder.binding.apply {
            Glide.with(context).load(mentor.imageUrl)
                .circleCrop()
                .placeholder(R.drawable.profile_circle)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageViewProfileImg)
            textViewName.text = mentor.name
            textViewLabel1.text = mentor.textOne
            textViewLabel2.text = mentor.textTwo
            textViewLabel3.text = mentor.textThree
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}