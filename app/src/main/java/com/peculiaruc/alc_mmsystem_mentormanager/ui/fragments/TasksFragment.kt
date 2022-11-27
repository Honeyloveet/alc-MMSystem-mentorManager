package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentTasksBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.TasksAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.viewmodels.TasksViewModel

class TasksFragment : Fragment() {

    private lateinit var binding: FragmentTasksBinding

    private lateinit var viewModel: TasksViewModel

    private lateinit var adapterTask: TasksAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTasksBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(requireActivity())[TasksViewModel::class.java]

        val activityTask = activity as AppCompatActivity

        activityTask.setSupportActionBar(binding.toolbar)

        binding.toolbar.setNavigationOnClickListener {
            //activity?.finish()
            activityTask.finish()
        }

        setUpRecyclerView()

        changeFilterControlsView("All")

        binding.chipAllTask.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                changeFilterControlsView("All")
            }
        }

        binding.chipAssignedTask.setOnCheckedChangeListener { _ , isChecked ->
            if (isChecked) {
                changeFilterControlsView("Assigned")
            }
        }

        binding.chipCompletedTask.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                changeFilterControlsView("Completed")
            }
        }

        binding.chipMyTasks.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                changeFilterControlsView("MyTasks")
            }
        }

        binding.fabCreateTask.setOnClickListener {
            findNavController().navigate(TasksFragmentDirections.actionTasksFragmentToNewTaskFragment())
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_search, menu)

//                val manager = requireContext().getSystemService(Context.SEARCH_SERVICE ) as SearchManager
//                val searchItem = menu.findItem(R.id.search_bar)
//                val searchView = searchItem.actionView as SearchView

//                searchView.setSearchableInfo(manager.getSearchableInfo(requireContext().componentName))
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.search_bar -> {
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        setUpRecyclerView()

        adapterTask.setOnItemClickListener(object : TasksAdapter.OnItemClickListener {
            override fun onItemClicked(position: Int) {
                findNavController().navigate(TasksFragmentDirections.actionTasksFragmentToTaskDetailsFragment())
            }

        })

        viewModel.getTasks.observe(viewLifecycleOwner) { tasks ->
            adapterTask.differ.submitList(tasks)
        }
    }

    private fun changeFilterControlsView(selected: String) {
        when (selected) {
            "All" -> {
                binding.chipAllTask.textSize = 16f
                binding.chipAssignedTask.textSize = 12f
                binding.chipCompletedTask.textSize = 12f
                binding.chipMyTasks.textSize = 12f
            }
            "Assigned" -> {
                binding.chipAllTask.textSize = 12f
                binding.chipAssignedTask.textSize = 16f
                binding.chipCompletedTask.textSize = 12f
                binding.chipMyTasks.textSize = 12f
            }
            "Completed" -> {
                binding.chipAllTask.textSize = 12f
                binding.chipAssignedTask.textSize = 12f
                binding.chipCompletedTask.textSize = 16f
                binding.chipMyTasks.textSize = 12f
            }
            "MyTasks" -> {
                binding.chipAllTask.textSize = 12f
                binding.chipAssignedTask.textSize = 12f
                binding.chipCompletedTask.textSize = 12f
                binding.chipMyTasks.textSize = 16f
            }
        }
    }

    private fun setUpRecyclerView() {
        adapterTask = TasksAdapter()
        binding.recyclerViewTasks.apply {
            adapter = adapterTask
            layoutManager = LinearLayoutManager(activity)
        }
    }

}