package com.example.sampleprojectforrecruitment.views.fragments.countrydetail

import androidx.lifecycle.MutableLiveData
import com.example.sampleprojectforrecruitment.base.BaseViewModel
import com.example.sampleprojectforrecruitment.models.response.CountryDetailResponse
import com.example.sampleprojectforrecruitment.models.response.CountryDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryDetailViewModel: BaseViewModel<CountryDetailViewModel.View>() {

    val countryDetail = MutableLiveData<CountryDetails>()

    fun getCountryDetail(country: String) {
        getView().showProgressBar()
        itemRepository.getCountryDetail()
            .enqueue(object : Callback<CountryDetailResponse> {
                override fun onResponse(
                    call: Call<CountryDetailResponse>,
                    response: Response<CountryDetailResponse>
                ) {
                    getView().dismissProgressBar()
                    response.run {
                        if (isSuccessful) {
                            body()?.response?.let {
                                it.forEach {
                                    if (it.country == country){
                                        countryDetail.value = it
                                    }
                                }
                            } ?: getView().onUpdateResponse("Something went wrong")
                        }
                    }
                }

                override fun onFailure(call: Call<CountryDetailResponse>, t: Throwable) {
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