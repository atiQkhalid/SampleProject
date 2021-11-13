package com.example.sampleprojectforrecruitment.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import com.example.sampleprojectforrecruitment.adapter.CountryAdapter
import com.example.sampleprojectforrecruitment.base.BaseFragment
import com.example.sampleprojectforrecruitment.databinding.FragmentHomeBinding
import com.example.sampleprojectforrecruitment.extenssions.showToastMsg


class CountryListFragment : BaseFragment(), CountryAdapter.OnCountryItemClickListener,
CountryViewModel.View{

    private lateinit var binding: FragmentHomeBinding
    private var countryAdapter: CountryAdapter? = null
    private val countryViewModel: CountryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        countryAdapter = CountryAdapter(this)

        countryViewModel.let {
            it.attachView(this)
            it.getCuriosityItemList()
        }

        onObserveItemList()

        countryViewModel.getCuriosityItemList()
        countryAdapter.let {
            binding.rvCountries.apply {
                itemAnimator = DefaultItemAnimator()
                adapter = it
            }
        }

    }

    //once we get the data from repo, populate it with the help of the adapter, NewsAdapter()
    private fun onObserveItemList() {
        countryViewModel.countryList.observe(viewLifecycleOwner) {
            it?.let {
                countryAdapter?.setItems(it)
            }
        }
    }

    override fun clickListener(country: String) {
        showToastMsg(country)
    }

    override fun onUpdateResponse(message: String) {
        showToastMsg(message)
    }

    override fun showProgressBar() {
        progressDialog.show()
    }

    override fun dismissProgressBar() {
        progressDialog.dismiss()
    }
}