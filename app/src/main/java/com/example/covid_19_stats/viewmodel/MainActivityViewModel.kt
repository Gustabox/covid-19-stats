package com.example.covid_19_stats.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.covid_19_stats.domain.repoimpl.RepositoryImpl
import com.example.covid_19_stats.util.resource.Resource
import kotlinx.coroutines.Dispatchers

class MainActivityViewModel : ViewModel() {

    private val repository = RepositoryImpl()

    fun getSpecificCountry(country: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(repository.getSpecificCountry(country)))
        } catch (e: Exception) {
            emit(Resource.error(null, e.toString()))
        }
    }

    fun getSpecificState(state: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(repository.getSpecificState(state)))
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

    fun getAllStates(test: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(repository.getAllStates(test)))
        } catch (e: Exception) {
            emit(Resource.error(null, e.toString()))
        }
    }
}