package com.example.covid_19_stats.model.state.all

import com.example.covid_19_stats.model.state.State
import com.google.gson.annotations.SerializedName

data class DataStateAll(
    @SerializedName("data")
    val stateList: List<State>
)