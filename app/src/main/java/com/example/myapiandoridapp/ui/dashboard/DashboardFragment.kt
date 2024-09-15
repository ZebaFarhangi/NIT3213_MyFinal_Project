package com.example.myapiandoridapp.ui.dashboard

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapiandoridapp.R
import com.example.myapiandoridapp.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {
    private val viewModel: DashboardViewModel by viewModels()
    private lateinit var binding: FragmentDashboardBinding
    private lateinit var adapter: EntityAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = EntityAdapter { entity ->
            // Navigate to DetailsFragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, DetailsFragment.newInstance(entity))
                .addToBackStack(null)
                .commit()
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.entities.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Success -> adapter.submitList(result.data)
                is Result.Error -> {
                    // Show error message
                    Toast.makeText(requireContext(), "Error loading dashboard: ${result.exception.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }

        viewModel.loadDashboard()
    }
}
