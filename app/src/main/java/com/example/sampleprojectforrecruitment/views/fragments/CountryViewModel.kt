package com.example.sampleprojectforrecruitment.views.fragments

import androidx.lifecycle.MutableLiveData
import com.example.sampleprojectforrecruitment.base.BaseViewModel
import com.example.sampleprojectforrecruitment.models.response.CountryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryViewModel : BaseViewModel<CountryViewModel.View>(){

    val countryItemList = MutableLiveData<List<CountryResponse>>()

    fun getCountryItemList() {
    }

    interface View {
        fun onUpdateResponse(message: String)
        fun showProgressBar()
        fun dismissProgressBar()
    }
}