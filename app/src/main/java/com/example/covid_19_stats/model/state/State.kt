package com.example.covid_19_stats.model.state

import com.google.gson.annotations.SerializedName

data class State(
    @SerializedName("state")
    val name: String,
    @SerializedName("cases")
    val cases: Int,
    @SerializedName("deaths")
    val deaths: Int,
    @SerializedName("suspects")
    val suspects: Int,
    @SerializedName("datetime")
    val dateTime: String
)