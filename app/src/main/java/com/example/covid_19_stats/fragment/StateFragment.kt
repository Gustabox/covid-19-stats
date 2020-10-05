package com.example.covid_19_stats.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import com.example.covid_19_stats.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class StateFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var autoCompleteState: AutoCompleteTextView

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
        val view = inflater.inflate(R.layout.fragment_state, container, false)
        findViews(view)

        setStateAutoComplete()
        return view
    }

    private fun findViews(view: View) {
        autoCompleteState = view.findViewById(R.id.autoCompleteState) as AutoCompleteTextView
    }

    private fun setStateAutoComplete() {
        val state: Array<String> = arrayOf("Todos", "São Paulo", "Rio de Janeiro")

        autoCompleteState.setText(state[0])

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