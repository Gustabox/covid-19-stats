package com.example.covid_19_stats.model.country

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("country")
    val name: String,
    @SerializedName("cases")
    val cases: Int,
    @SerializedName("confirmed")
    val confirmed: Int,
    @SerializedName("deaths")
    val deaths: Int,
    @SerializedName("recovered")
    val recovered: Int,
    @SerializedName("updated_at")
    val updatedAt: String
)