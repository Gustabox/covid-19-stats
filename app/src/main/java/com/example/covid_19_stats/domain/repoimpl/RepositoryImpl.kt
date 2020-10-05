package com.example.covid_19_stats.domain.repoimpl

import com.example.covid_19_stats.data.repo.Repository
import com.example.covid_19_stats.rest.endpoint.EndPoint
import com.example.covid_19_stats.rest.retrofit.RetrofitConfig

class RepositoryImpl : Repository {

    private val endPoint = RetrofitConfig.getClient().create(EndPoint::class.java)

    override suspend fun getSpecificState(state: String) = endPoint.getSpecificState(state)

    override suspend fun getSpecificCountry(country: String) = endPoint.getSpecificCountry(country)

    override suspend fun getAllStates(test: String) = endPoint.getAllStates(test)

    override suspend fun getAllCountries() = endPoint.getAllCountries()

}