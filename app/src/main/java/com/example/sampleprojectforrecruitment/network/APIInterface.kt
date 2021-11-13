package com.example.sampleprojectforrecruitment.network

import com.example.sampleprojectforrecruitment.models.response.CountryDetailResponse
import com.example.sampleprojectforrecruitment.models.response.CountryResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * The APIInterface.kt
 */
interface ApiInterface {

    @GET("countries")
    fun getAllCountries(): Call<CountryResponse>

    @GET("statistics")
    fun getCountryDetail(): Call<CountryDetailResponse>
}