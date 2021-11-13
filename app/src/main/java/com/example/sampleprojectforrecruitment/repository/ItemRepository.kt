package com.example.sampleprojectforrecruitment.repository

import com.example.sampleprojectforrecruitment.base.BaseRepository
import com.example.sampleprojectforrecruitment.network.RetrofitClient
import com.example.sampleprojectforrecruitment.utils.Constants.BASE_URL


class ItemRepository : BaseRepository() {

    ////API End pints
    fun getCountryList() =
        RetrofitClient.getInterfaceService(
            BASE_URL
        ).getAllCountries()

    companion object {
        private var instance: ItemRepository? = null
        fun getInstance(): ItemRepository {
            if (instance == null)
                instance =
                    ItemRepository()
            return instance!!
        }
    }
}