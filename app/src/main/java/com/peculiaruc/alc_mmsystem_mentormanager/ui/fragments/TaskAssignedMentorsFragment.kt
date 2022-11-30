package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentTaskAssignedMentorsBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.TaskAssignedMentorsAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.viewmodels.TaskAssignedMentorsViewModel

/**
 * this fragment is used to show the list of mentors
 * who are assigned to a specific task
 */
class TaskAssignedMentorsFragment : Fragment() {

    private var _binding: FragmentTaskAssignedMentorsBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: TaskAssignedMentorsViewModel

    private lateinit var adapterMentors: TaskAssignedMentorsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTaskAssignedMentorsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[TaskAssignedMentorsViewModel::class.java]

        val activityTask = activity as AppCompatActivity

        activityTask.setSupportActionBar(binding.toolbar)

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        setUpRecyclerView()

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getMentors.observe(viewLifecycleOwner) { mentors ->
            adapterMentors.differ.submitList(mentors)
        }

    }

    private fun setUpRecyclerView() {
        adapterMentors = TaskAssignedMentorsAdapter(requireContext())
        binding.recyclerViewMentors.apply {
            adapter = adapterMentors
            layoutManager = LinearLayoutManager(activity)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}