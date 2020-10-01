package com.example.covid_19_stats.rest.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {

    companion object {
        private const val URL = "https://covid19-brazil-api.now.sh/api/report/v1/"

        fun getClient(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}