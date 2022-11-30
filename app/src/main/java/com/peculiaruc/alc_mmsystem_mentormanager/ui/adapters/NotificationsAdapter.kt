package com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.NotificationDto
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ItemNotificationBinding

/**
 * Notification Adapter for [NotificationDto]
 */
class NotificationsAdapter (
    private val notificationClickListener : (NotificationDto) -> Unit,
) :
    ListAdapter<NotificationDto, NotificationsAdapter.ViewHolder>(NotificationsDiffCallback()) {

    class ViewHolder(val binding: ItemNotificationBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item : NotificationDto,
            notificationClickListener : (NotificationDto) -> Unit,
        )
        {
            binding.root.setOnClickListener {
                notificationClickListener.invoke(item)
            }
        }

        companion object {
            /**
             * for returning ViewHolder on [onCreateViewHolder] function
             */
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemNotificationBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position),notificationClickListener)

}

/**
 * DiffUtil call back used to check oldItem with newItem for
 * [NotificationDto]
 */
class NotificationsDiffCallback : DiffUtil.ItemCallback<NotificationDto>() {
    override fun areItemsTheSame(oldItem: NotificationDto, newItem: NotificationDto): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: NotificationDto, newItem: NotificationDto): Boolean {
        return oldItem.id == newItem.id
    }

}