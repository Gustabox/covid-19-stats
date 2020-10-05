package com.example.covid_19_stats.rest.endpoint

import com.example.covid_19_stats.model.country.Data
import com.example.covid_19_stats.model.country.all.DataCountryAll
import com.example.covid_19_stats.model.state.State
import com.example.covid_19_stats.model.state.all.DataStateAll
import retrofit2.http.GET
import retrofit2.http.Path

interface EndPoint {

    @GET("brazil/uf/{state}")
    suspend fun getSpecificState(@Path("state") state: String): State

    @GET("{country}")
    suspend fun getSpecificCountry(@Path("country") country: String): Data

    @GET("{emptyPath}")
    suspend fun getAllStates(@Path("emptyPath") test: String): DataStateAll

    @GET("countries")
    suspend fun getAllCountries(): DataCountryAll

}