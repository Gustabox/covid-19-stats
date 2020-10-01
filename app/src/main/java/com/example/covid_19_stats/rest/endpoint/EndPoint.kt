package com.example.covid_19_stats.rest.endpoint

import com.example.covid_19_stats.model.country.Data
import retrofit2.http.GET

interface EndPoint {

    @GET("countries")
    fun getAllCountries(): Data

}