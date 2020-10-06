package com.example.covid_19_stats.view

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.covid_19_stats.R
import com.example.covid_19_stats.fragment.CountryFragment
import com.example.covid_19_stats.fragment.StateFragment
import com.example.covid_19_stats.view.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        setTabLayoutAdapter()
    }

    private fun setTabLayoutAdapter() {
        val countryFragment = CountryFragment()
        val stateFragment = StateFragment()

        tabLayout.setupWithViewPager(viewPager)

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, 0)
        viewPagerAdapter.addFragment(countryFragment, "COUNTRIES")
        viewPagerAdapter.addFragment(stateFragment, "STATES (BRAZIL)")

        viewPager.adapter = viewPagerAdapter
    }
}