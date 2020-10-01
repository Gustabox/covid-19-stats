package com.example.covid_19_stats.viewmodel

import androidx.lifecycle.liveData
import com.example.covid_19_stats.domain.repoimpl.RepositoryImpl
import com.example.covid_19_stats.util.resource.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MainActivityViewModel {

    private val repository = RepositoryImpl()

    fun getSpecificCountry(country: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(repository.getSpecificCountry(country)))
        } catch (e: Exception) {
            emit(Resource.error(null, e.toString()))
        }
    }

    fun getAllCountries() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(repository.getAllCountries()))
        } catch (e: Exception) {
            emit(Resource.error(null, e.toString()))
        }
    }

}