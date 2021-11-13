package com.example.sampleprojectforrecruitment.models.response

data class CountryResponse(
    val errors: List<String>,
    val results: Int,
    val response: List<String>
)