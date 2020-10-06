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
import com.example.covid_19_stats.model.state.State
import com.example.covid_19_stats.util.const.StateConstants
import com.example.covid_19_stats.util.resource.Status
import com.example.covid_19_stats.view.adapter.RecyclerAdapterStateCase
import com.example.covid_19_stats.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_state.*
import java.text.DecimalFormat

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class StateFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var autoCompleteState: AutoCompleteTextView
    private lateinit var buttonSearchState: Button
    private var listOfStates = ArrayList<State>()
    private lateinit var state: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        getAllStates()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_state, container, false)
        findViews(view)

        setStateAutoComplete()
        buttonSearchClick()

        getAllStates()

        return view
    }

    private fun buttonSearchClick() {
        buttonSearchState.setOnClickListener {
            setStateUF()
        }
    }

    private fun setStateUF() {
        val selectedState = autoCompleteState.text.toString()

        if (selectedState == state[0]) showViewWithInformations(StateConstants.SP)
        if (selectedState == state[1]) showViewWithInformations(StateConstants.BA)
        if (selectedState == state[2]) showViewWithInformations(StateConstants.MG)
        if (selectedState == state[3]) showViewWithInformations(StateConstants.RJ)
        if (selectedState == state[4]) showViewWithInformations(StateConstants.CE)
        if (selectedState == state[5]) showViewWithInformations(StateConstants.PA)
        if (selectedState == state[6]) showViewWithInformations(StateConstants.SC)
        if (selectedState == state[7]) showViewWithInformations(StateConstants.GO)
        if (selectedState == state[8]) showViewWithInformations(StateConstants.RS)
        if (selectedState == state[9]) showViewWithInformations(StateConstants.DF)
        if (selectedState == state[10]) showViewWithInformations(StateConstants.PR)

        if (selectedState == state[11]) showViewWithInformations(StateConstants.MA)
        if (selectedState == state[12]) showViewWithInformations(StateConstants.PE)
        if (selectedState == state[13]) showViewWithInformations(StateConstants.AM)
        if (selectedState == state[14]) showViewWithInformations(StateConstants.ES)
        if (selectedState == state[15]) showViewWithInformations(StateConstants.MT)
        if (selectedState == state[16]) showViewWithInformations(StateConstants.PB)
        if (selectedState == state[17]) showViewWithInformations(StateConstants.PI)

        if (selectedState == state[18]) showViewWithInformations(StateConstants.AL)
        if (selectedState == state[19]) showViewWithInformations(StateConstants.SE)
        if (selectedState == state[20]) showViewWithInformations(StateConstants.MS)
        if (selectedState == state[21]) showViewWithInformations(StateConstants.RN)
        if (selectedState == state[22]) showViewWithInformations(StateConstants.TO)
        if (selectedState == state[23]) showViewWithInformations(StateConstants.TO)
        if (selectedState == state[24]) showViewWithInformations(StateConstants.RR)
        if (selectedState == state[25]) showViewWithInformations(StateConstants.AP)
        if (selectedState == state[26]) showViewWithInformations(StateConstants.AC)
    }

    @SuppressLint("LongLogTag")
    private fun showViewWithInformations(stateName: String) {
        val progressDialog = ProgressDialog(activity, R.style.alertDialogStyle)
        progressDialog.setMessage("Loading...")

        val mainActivityViewModel = MainActivityViewModel()
        mainActivityViewModel.getSpecificState(stateName)
            .observe(this, androidx.lifecycle.Observer {
                it?.let { resource ->
                    when (resource.status) {
                        Status.LOADING -> {
                            progressDialog.show()
                        }
                        Status.SUCCESS -> {
                            resource.data?.let {
                                if (progressDialog.isShowing) progressDialog.dismiss()
                                setSpecificStateInformations(resource.data)
                            }!!
                        }
                        Status.ERROR -> {
                            if (progressDialog.isShowing) progressDialog.dismiss()
                            Log.e("Error in specific state request ", resource.message.toString())
                        }
                    }
                }
            })
    }

    private fun setSpecificStateInformations(state: State) {
        setViewsVisibility(
            setToVisible = constraintLayoutSpecificState,
            setToGone = constraintLayoutAllStates
        )
        val formatter = DecimalFormat("#,###,###")

        textViewFragmentStateName.text = state.name
        textViewStateDeaths.text = formatter.format(state.deaths.toString().toInt())
        textViewStateCases.text = formatter.format(state.cases.toString().toInt())
        textViewStateSuspects.text = formatter.format(state.suspects.toString().toInt())
        textViewFragmentStateDateTime.text = state.dateTime
    }

    @SuppressLint("LongLogTag")
    private fun getAllStates() {
        val mainActivityViewModel = MainActivityViewModel()
        mainActivityViewModel.getAllStates("").observe(this, androidx.lifecycle.Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.LOADING -> {
                        Log.d("Loading all countries request ", "loading...")
                    }
                    Status.SUCCESS -> {
                        resource.data?.let {
                            listOfStates = resource.data.listState

                            setRecyclerAdapter(listOfStates)
                        }!!
                    }
                    Status.ERROR -> {
                        Log.e("Error in all countries request ", resource.message.toString())
                    }
                }
            }
        })
    }

    private fun setRecyclerAdapter(listOfStates: ArrayList<State>) {
        val recyclerAdapter = RecyclerAdapterStateCase(listOfStates)
        recyclerViewAllStates.adapter = recyclerAdapter
        recyclerViewAllStates.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        recyclerAdapter.notifyDataSetChanged()
    }

    private fun setViewsVisibility(setToVisible: ConstraintLayout, setToGone: ConstraintLayout) {
        setToVisible.visibility = View.VISIBLE
        setToGone.visibility = View.GONE
    }

    private fun findViews(view: View) {
        autoCompleteState = view.findViewById(R.id.autoCompleteState) as AutoCompleteTextView
        buttonSearchState = view.findViewById(R.id.buttonSearchState) as Button
    }

    private fun setStateAutoComplete() {
        state = resources.getStringArray(R.array.arrayOfStates)

        autoCompleteState.setAdapter(
            ArrayAdapter<String>(
                activity!!.applicationContext,
                android.R.layout.simple_list_item_1,
                state
            )
        )
        autoCompleteState.setOnClickListener {
            autoCompleteState.showDropDown()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StateFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}