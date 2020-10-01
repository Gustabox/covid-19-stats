package com.example.covid_19_stats.model.country.all

import com.example.covid_19_stats.model.country.Country
import com.google.gson.annotations.SerializedName

data class DataCountryAll(
    @SerializedName("data")
    val countryList: List<Country>
)