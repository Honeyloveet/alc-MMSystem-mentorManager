package com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.ProgramDto
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ItemProgramBinding

class ProgramAdapter (
    private val programClickListener : (ProgramDto) -> Unit,
) :
    ListAdapter<ProgramDto, ProgramAdapter.ViewHolder>(ProgramDiffCallback()) {

    class ViewHolder(val binding: ItemProgramBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item : ProgramDto,
            programClickListener : (ProgramDto) -> Unit,
        )
        {
            binding.textViewDocumentName.text = item.name
            binding.root.setOnClickListener {
                programClickListener.invoke(item)
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemProgramBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position),programClickListener)

}

class ProgramDiffCallback : DiffUtil.ItemCallback<ProgramDto>() {
    override fun areItemsTheSame(oldItem: ProgramDto, newItem: ProgramDto): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ProgramDto, newItem: ProgramDto): Boolean {
        return oldItem.id == newItem.id
    }

}