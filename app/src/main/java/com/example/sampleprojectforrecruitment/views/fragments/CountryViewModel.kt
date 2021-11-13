package com.example.sampleprojectforrecruitment.views.fragments

import androidx.lifecycle.MutableLiveData
import com.example.sampleprojectforrecruitment.base.BaseViewModel
import com.example.sampleprojectforrecruitment.models.response.CountryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryViewModel : BaseViewModel<CountryViewModel.View>(){

    val countryList = MutableLiveData<List<String>>()

    fun getCuriosityItemList() {
        getView().showProgressBar()
        itemRepository.getCountryList()
            .enqueue(object : Callback<CountryResponse> {
                override fun onResponse(
                    call: Call<CountryResponse>,
                    response: Response<CountryResponse>
                ) {
                    getView().dismissProgressBar()
                    response.run {
                        if (isSuccessful) {
                            body()?.response?.let {
                                countryList.value = it
                            } ?: getView().onUpdateResponse("Something went wrong")
                        }
                    }
                }

                override fun onFailure(call: Call<CountryResponse>, t: Throwable) {
                    getView().dismissProgressBar()
                    getView().onUpdateResponse(t.message.toString())
                }
            })
    }

    interface View {
        fun onUpdateResponse(message: String)
        fun showProgressBar()
        fun dismissProgressBar()
    }
}