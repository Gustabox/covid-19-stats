package com.example.covid_19_stats.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covid_19_stats.R
import com.example.covid_19_stats.model.country.Country
import com.example.covid_19_stats.model.country.all.DataCountryAll

class RecyclerAdapterCountry(private val countryList: List<DataCountryAll>) :
    RecyclerView.Adapter<RecyclerAdapterCountry.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_states_cases, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(countryList[position].countryList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(country: Country) {
//            itemView.textViewCountryListName.text = country.name
//            itemView.textViewCountryListCases.text = country.cases.toString()
//            itemView.textViewCountryListConfirmed.text = country.cases.toString()
//            itemView.textViewCountryListDeaths.text = country.deaths.toString()
//            itemView.textViewCountryListRecovered.text = country.recovered.toString()
//            itemView.textViewCountryListUpdatedAt.text = country.updatedAt
        }
    }
}