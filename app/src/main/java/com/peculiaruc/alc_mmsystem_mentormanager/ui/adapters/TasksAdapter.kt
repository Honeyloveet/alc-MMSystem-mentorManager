package com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Task
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ListTasksItemBinding
import java.text.SimpleDateFormat
import java.util.*

/**
 * An adapter for list of Tasks
 */
class TasksAdapter : RecyclerView.Adapter<TasksAdapter.TasksAdapterViewHolder>() {

    private lateinit var clickListener : OnItemClickListener

    /**
     * An interface which listens clicks
     * when a task is clicked form the list
     */
    interface OnItemClickListener {
        /**
         * function for task click listener
         * with position of the adapter
         */
        fun onItemClicked(position: Int)
    }

    /**
     * sets the click listener for [clickListener]
     */
    fun setOnItemClickListener(listener: OnItemClickListener) {
        clickListener = listener
    }

    inner class TasksAdapterViewHolder(val binding: ListTasksItemBinding, listener: OnItemClickListener) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                listener.onItemClicked(adapterPosition)
            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksAdapterViewHolder {
        return TasksAdapterViewHolder(ListTasksItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ), clickListener)
    }

    override fun onBindViewHolder(holder: TasksAdapterViewHolder, position: Int) {
        val task = differ.currentList[position]
        holder.binding.apply {
            textViewTaskTitle.text = task.title
            textViewDate.text = SimpleDateFormat("dd.MM.yyyy hh:mm", Locale.getDefault()).format(Date(task.date_created))
            textViewStatus.text = task.status
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}