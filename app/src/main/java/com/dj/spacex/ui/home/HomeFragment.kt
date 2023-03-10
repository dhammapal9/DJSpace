package com.dj.spacex.ui.home

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.dj.spacex.R
import com.dj.spacex.databinding.FragmentHomeBinding
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : DaggerFragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var homeViewModel: HomeViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        AndroidSupportInjection.inject(this)
        homeViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.viewModel = homeViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.menuList.observe(viewLifecycleOwner, Observer {
            initRecyclerView(it)
        })
        setHasOptionsMenu(true)
    }

    private fun initRecyclerView(data: List<String>) {
        homeAdapter = HomeAdapter()
        home_recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 2)
            adapter = homeAdapter
            homeAdapter.addMenuItemToList(data)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
