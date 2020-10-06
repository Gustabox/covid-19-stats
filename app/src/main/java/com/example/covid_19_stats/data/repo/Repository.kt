package com.example.covid_19_stats.data.repo

import com.example.covid_19_stats.model.country.Data
import com.example.covid_19_stats.model.country.all.DataCountryAll
import com.example.covid_19_stats.model.state.State
import com.example.covid_19_stats.model.state.all.DataStateAll

interface Repository {
    suspend fun getSpecificState(state: String): State
    suspend fun getSpecificCountry(country: String): Data
    suspend fun getAllStates(test: String): DataStateAll
    suspend fun getAllCountries(): DataCountryAll
}