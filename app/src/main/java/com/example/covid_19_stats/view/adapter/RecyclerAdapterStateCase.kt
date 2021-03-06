package com.example.covid_19_stats.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covid_19_stats.R
import com.example.covid_19_stats.model.state.State
import kotlinx.android.synthetic.main.recycler_view_states_cases.view.*
import java.text.DecimalFormat

class RecyclerAdapterStateCase(private val stateList: List<State>) : RecyclerView.Adapter<RecyclerAdapterStateCase.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_states_cases, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return stateList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(stateList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(state: State) {
            val formatter = DecimalFormat("##,###,###")

            itemView.textViewStateName.text = state.name
            itemView.textViewDeaths.text = formatter.format(state.deaths.toString().toInt())
            itemView.textViewCases.text = formatter.format(state.cases.toString().toInt())
            itemView.textViewSuspects.text = formatter.format(state.suspects.toString().toInt())
            itemView.textViewStateDateTime.text = state.dateTime
        }
    }
}