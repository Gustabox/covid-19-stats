package com.example.covid_19_stats.fragment

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covid_19_stats.R
import com.example.covid_19_stats.model.country.Country
import com.example.covid_19_stats.model.country.Data
import com.example.covid_19_stats.util.resource.Status
import com.example.covid_19_stats.view.adapter.RecyclerAdapterCountry
import com.example.covid_19_stats.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_country.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CountryFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var autoCompleteCountry: AutoCompleteTextView
    private lateinit var buttonSearchCountry: Button
    private var listOfAllCountries = ArrayList<Country>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_country, container, false)
        findViews(view)

        setCountryAutoComplete()
        buttonSearchClick()

        getAllCountries()

        return view
    }

    private fun buttonSearchClick() {
        buttonSearchCountry.setOnClickListener {
            showViewWithInformations(autoCompleteCountry.text.toString())
        }
    }

    @SuppressLint("LongLogTag")
    private fun showViewWithInformations(countryName: String) {
        val progressDialog = ProgressDialog(activity, R.style.alertDialogStyle)
        progressDialog.setMessage("Loading...")

        val mainActivityViewModel = MainActivityViewModel()
        mainActivityViewModel.getSpecificCountry(countryName)
            .observe(this, androidx.lifecycle.Observer {
                it?.let { resource ->
                    when (resource.status) {
                        Status.LOADING -> {
                            progressDialog.show()
                        }
                        Status.SUCCESS -> {
                            resource.data?.let {
                                if (progressDialog.isShowing) progressDialog.dismiss()
                                setSpecificCountryInformations(resource.data)
                            }!!
                        }
                        Status.ERROR -> {
                            if (progressDialog.isShowing) progressDialog.dismiss()
                            Log.e("Error in specific country request ", resource.message.toString())
                        }
                    }
                }
            })
    }

    private fun setSpecificCountryInformations(country: Data) {
        setViewsVisibility(
            setToVisible = constraintLayoutSpecificCountry,
            setToGone = constraintLayoutAllCountries
        )
        textViewCountryName.text = country.data.name
        textViewCountryCases.text = country.data.cases.toString()
        textViewCountryConfirmed.text = country.data.confirmed.toString()
        textViewCountryDeaths.text = country.data.deaths.toString()
        textViewCountryRecovered.text = country.data.recovered.toString()
    }

    private fun setViewsVisibility(
        setToVisible: ConstraintLayout,
        setToGone: ConstraintLayout
    ) {
        setToVisible.visibility = View.VISIBLE
        setToGone.visibility = View.GONE
    }

    @SuppressLint("LongLogTag")
    private fun getAllCountries() {
        val mainActivityViewModel = MainActivityViewModel()
        mainActivityViewModel.getAllCountries().observe(this, androidx.lifecycle.Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.LOADING -> {
                        Log.d("Loading all countries request ", "loading...")
                    }
                    Status.SUCCESS -> {
                        resource.data?.let {
                            listOfAllCountries = resource.data.countryList

                            setRecyclerAdapter(listOfAllCountries)
                        }!!
                    }
                    Status.ERROR -> {
                        Log.e("Error in all countries request ", resource.message.toString())
                    }
                }
            }
        })
    }

    private fun setRecyclerAdapter(listOfAllCountries: ArrayList<Country>) {
        val recyclerAdapter = RecyclerAdapterCountry(listOfAllCountries)
        recyclerViewAllCountries.adapter = recyclerAdapter
        recyclerViewAllCountries.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        recyclerAdapter.notifyDataSetChanged()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setCountryAutoComplete() {
        val country: Array<String> = resources.getStringArray(R.array.arrayOfCountries)

        autoCompleteCountry.setAdapter(
            ArrayAdapter<String>(
                activity!!.applicationContext,
                android.R.layout.simple_list_item_1,
                country
            )
        )
    }

    private fun findViews(view: View) {
        autoCompleteCountry = view.findViewById(R.id.autoCompleteCountry) as AutoCompleteTextView
        buttonSearchCountry = view.findViewById(R.id.buttonSearchCountry) as Button
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CountryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}