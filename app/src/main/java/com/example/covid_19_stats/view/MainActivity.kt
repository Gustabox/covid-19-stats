package com.example.covid_19_stats.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.covid_19_stats.R
import com.example.covid_19_stats.fragment.CountryFragment
import com.example.covid_19_stats.fragment.StateFragment
import com.example.covid_19_stats.util.resource.Status
import com.example.covid_19_stats.view.adapter.ViewPagerAdapter
import com.example.covid_19_stats.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTabLayoutAdapter()

        testingEndPoint()
    }

    private fun setTabLayoutAdapter() {
        val countryFragment = CountryFragment()
        val stateFragment = StateFragment()

        tabLayout.setupWithViewPager(viewPager)

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, 0)
        viewPagerAdapter.addFragment(countryFragment, "PAÍSES")
        viewPagerAdapter.addFragment(stateFragment, "ESTADOS (BR)")

        viewPager.adapter = viewPagerAdapter
    }

    @SuppressLint("LongLogTag")
    private fun testingEndPoint() {
        val mainActivityViewModel = MainActivityViewModel()
        mainActivityViewModel.getAllCountries().observe(this, androidx.lifecycle.Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.LOADING -> {
                        Log.d("Loading ", "loading...")
                    }
                    Status.SUCCESS -> {
                        Log.d("Debugging this ", resource.data?.countryList!![0].name)
                    }
                    Status.ERROR -> {
                        Log.e("Error trying get all countries ", resource.message.toString())
                    }
                }
            }
        })
    }
}