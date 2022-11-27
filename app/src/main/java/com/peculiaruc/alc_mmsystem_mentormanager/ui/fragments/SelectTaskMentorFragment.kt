package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentSelectTaskMentorBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.SelectMentorAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.viewmodels.SelectMentorViewModel

class SelectTaskMentorFragment : Fragment() {

    private var _binding: FragmentSelectTaskMentorBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: SelectMentorViewModel

    private lateinit var adapterMentor: SelectMentorAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSelectTaskMentorBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[SelectMentorViewModel::class.java]

        val activityTask = activity as AppCompatActivity

        activityTask.setSupportActionBar(binding.toolbar)

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        binding.buttonDone.setOnClickListener {
            findNavController().navigate(SelectTaskMentorFragmentDirections.actionSelectTaskMentorFragmentToNewTaskFragment())
        }

        setUpRecyclerView()

        fillFilterList()

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getMentors.observe(viewLifecycleOwner) { mentors ->
            adapterMentor.differ.submitList(mentors)
        }

    }

    private fun setUpRecyclerView() {
        adapterMentor = SelectMentorAdapter(requireContext())
        binding.recyclerViewMentors.apply {
            adapter = adapterMentor
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun fillFilterList() {
        val filterList = listOf("All Mentors", "Assigned", "Unassigned")
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, filterList)
        binding.dropdownMentorFilter.setAdapter(adapter)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}