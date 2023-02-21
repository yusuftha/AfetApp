package com.moonsoft.afetapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.moonsoft.afetapp.adapter.DepremAdapter
import com.moonsoft.afetapp.viewModel.DepremViewModel
import com.moonsoft.afetapp.R
import com.moonsoft.afetapp.databinding.FragmentDepremBinding
import kotlinx.android.synthetic.main.fragment_deprem.*

class DepremFragment : Fragment() {
    private lateinit var depremViewModel: DepremViewModel
    private lateinit var binding: FragmentDepremBinding
    private val depremAdapter = DepremAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDepremBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        depremViewModel = ViewModelProvider(this).get(DepremViewModel::class.java)
        depremViewModel.refreshData()

        deprem_list.layoutManager = LinearLayoutManager(context)
        deprem_list.adapter = depremAdapter

        depremAdapter.depremItemClickListener = { latitude, longitude ->
            Navigation.findNavController(view).navigate(
                R.id.action_deprem_fragment_to_maps_fragment,
                bundleOf(lat to latitude, lng to longitude)
            )
        }
        observeDepremListLiveData()
    }

    private fun observeDepremListLiveData() {
        depremViewModel.getDepremListLiveData.observe(
            viewLifecycleOwner, Observer {
                it?.let {
                    depremAdapter.depremUpdate(it.result)
                }
            })
    }

    companion object {
        const val lat = "lat"
        const val lng = "lng"
    }
}
