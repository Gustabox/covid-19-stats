package com.example.covid_19_stats.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covid_19_stats.R
import com.example.covid_19_stats.model.country.Country
import com.example.covid_19_stats.model.country.all.DataCountryAll
import kotlinx.android.synthetic.main.recycler_view_country_cases.view.*
import java.text.DecimalFormat

class RecyclerAdapterCountry(private val countryList: List<Country>) :
    RecyclerView.Adapter<RecyclerAdapterCountry.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_country_cases, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(countryList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(country: Country) {
            val formatter = DecimalFormat("##,###,###")

            itemView.textViewCountryListName.text = country.name
            itemView.textViewCountryListCases.text = formatter.format(country.cases.toString().toInt())
            itemView.textViewCountryListConfirmed.text = formatter.format(country.cases.toString().toInt())
            itemView.textViewCountryListDeaths.text = formatter.format(country.deaths.toString().toInt())
            itemView.textViewCountryListRecovered.text = formatter.format(country.recovered.toString().toInt())
        }
    }
}