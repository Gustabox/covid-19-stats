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
        setCountryInformations()
        getAllCountries()

        return view
    }

    private fun buttonSearchClick() {
        buttonSearchCountry.setOnClickListener {
            setCountryInformations()
        }
    }

    private fun setCountryInformations() {
        if (autoCompleteCountry.text.isNotEmpty()) {
            /** The last parameter of the country request is a lowercase English word. As countries
             *  need to be in Portuguese, it is necessary to check which country is selected in order
             *  to translate it into English and convert it into lower case. */

            val searchedCountry = autoCompleteCountry.text.toString()

            if (searchedCountry == "Afeganistão") showViewWithInformations("Afghanistan")
            if (searchedCountry == "Albânia") showViewWithInformations("Albania")
            if (searchedCountry == "Argélia") showViewWithInformations("Algeria")
            if (searchedCountry == "Angola") showViewWithInformations("Angola")
            if (searchedCountry == "Antigua e Barbuda") showViewWithInformations(
                "Antigua and Barbuda"
            )
            if (searchedCountry == "Argentina") showViewWithInformations("Argentina")
            if (searchedCountry == "Armênia") showViewWithInformations("Armenia")
            if (searchedCountry == "Austrália") showViewWithInformations("Australia")
            if (searchedCountry == "Áustria") showViewWithInformations("Austria")
            if (searchedCountry == "Azerbaijão") showViewWithInformations("Azerbaijan")
            if (searchedCountry == "Bahamas") showViewWithInformations("Bahamas")
            if (searchedCountry == "Bahrain") showViewWithInformations("Bahrain")
            if (searchedCountry == "Bangladesh") showViewWithInformations("Bangladesh")
            if (searchedCountry == "Barbadás") showViewWithInformations("Barbados")
            if (searchedCountry == "Bielorrússia") showViewWithInformations("Belarus")
            if (searchedCountry == "Bélgica") showViewWithInformations("Belgium")
            if (searchedCountry == "Benin") showViewWithInformations("Benin")
            if (searchedCountry == "Butão") showViewWithInformations("Bhutan")
            if (searchedCountry == "Bolívia") showViewWithInformations("Bolivia")
            if (searchedCountry == "Bósnia e Herzegovina") showViewWithInformations(
                "Bosnia and Herzegovina"
            )
            if (searchedCountry == "Botsuana") showViewWithInformations("Botswana")
            if (searchedCountry == "Brasil") showViewWithInformations("Brazil")
            if (searchedCountry == "Brunei") showViewWithInformations("Brunei")
            if (searchedCountry == "Bulgária") showViewWithInformations("Bulgaria")
            if (searchedCountry == "Burkina Faso") showViewWithInformations("Burkina Faso")
            if (searchedCountry == "Birmânia") showViewWithInformations("Burma")
            if (searchedCountry == "Burundi") showViewWithInformations("Burundi")
            if (searchedCountry == "Cabo Verde") showViewWithInformations("Cabo Verde")
            if (searchedCountry == "Camboja") showViewWithInformations("Cambodia")
            if (searchedCountry == "Camarões") showViewWithInformations("Cameroon")
            if (searchedCountry == "Canadá") showViewWithInformations("Canada")
            if (searchedCountry == "República Centro-Africana") showViewWithInformations(
                "Central African Republic"
            )
            if (searchedCountry == "Chade") showViewWithInformations("Chad")
            if (searchedCountry == "Chile") showViewWithInformations("Chile")
            if (searchedCountry == "China") showViewWithInformations("China")
            if (searchedCountry == "Colômbia") showViewWithInformations("Colombia")
            if (searchedCountry == "Comores") showViewWithInformations("Comoros")
            if (searchedCountry == "Costa Rica") showViewWithInformations("Costa Rica")
            if (searchedCountry == "Costa do Marfim") showViewWithInformations("Costa do Marfim")
            if (searchedCountry == "Croácia") showViewWithInformations("Croatia")
            if (searchedCountry == "Cuba") showViewWithInformations("Cuba")
            if (searchedCountry == "Chipre") showViewWithInformations("Cyprus")
            if (searchedCountry == "Tchéquia") showViewWithInformations("Czechia")
            if (searchedCountry == "Dinamarca") showViewWithInformations("Denmark")
            if (searchedCountry == "Djibouti") showViewWithInformations("Djibouti")
            if (searchedCountry == "Dominica") showViewWithInformations("Dominica")
            if (searchedCountry == "República Dominicana") showViewWithInformations(
                "Dominican Republic"
            )
            if (searchedCountry == "Equador") showViewWithInformations("Ecuador")
            if (searchedCountry == "Egito") showViewWithInformations("Egypt")
            if (searchedCountry == "El Salvador") showViewWithInformations("El Salvador")
            if (searchedCountry == "Guiné Equatorial") showViewWithInformations(
                "Equatorial Guinea"
            )
            if (searchedCountry == "Eritreia") showViewWithInformations("Eritrea")
            if (searchedCountry == "Estônia") showViewWithInformations("Estonia")
            if (searchedCountry == "Suazilândia") showViewWithInformations("Swaziland")
            if (searchedCountry == "Etiópia") showViewWithInformations("Ethiopia")
            if (searchedCountry == "Fiji") showViewWithInformations("Fiji")
            if (searchedCountry == "Finlândia") showViewWithInformations("Finland")
            if (searchedCountry == "França") showViewWithInformations("France")
            if (searchedCountry == "Gabão") showViewWithInformations("Gabon")
            if (searchedCountry == "Georgia") showViewWithInformations("Georgia")
            if (searchedCountry == "Alemanha") showViewWithInformations("Germany")
            if (searchedCountry == "Gana") showViewWithInformations("Ghana")
            if (searchedCountry == "Grécia") showViewWithInformations("Greece")
            if (searchedCountry == "Grenada") showViewWithInformations("Grenada")
            if (searchedCountry == "Guatemala") showViewWithInformations("Guatemala")
            if (searchedCountry == "Guiné") showViewWithInformations("Guinea")
            if (searchedCountry == "Guiné-Bissau") showViewWithInformations("Guinea Bissau")
            if (searchedCountry == "Guiana") showViewWithInformations("Guyana")
            if (searchedCountry == "Haiti") showViewWithInformations("Haiti")
            if (searchedCountry == "Santa Sé") showViewWithInformations("Holy See")
            if (searchedCountry == "Honduras") showViewWithInformations("Honduras")
            if (searchedCountry == "Hungria") showViewWithInformations("Hungary")
            if (searchedCountry == "Islândia") showViewWithInformations("Iceland")
            if (searchedCountry == "Índia") showViewWithInformations("India")
            if (searchedCountry == "Indonésia") showViewWithInformations("Indonesia")
            if (searchedCountry == "Irã") showViewWithInformations("Iran")
            if (searchedCountry == "Iraque") showViewWithInformations("Iraq")
            if (searchedCountry == "Irlanda") showViewWithInformations("Ireland")
            if (searchedCountry == "Israel") showViewWithInformations("Israel")
            if (searchedCountry == "Itália") showViewWithInformations("Italy")
            if (searchedCountry == "Jamaica") showViewWithInformations("Jamaica")
            if (searchedCountry == "Japão") showViewWithInformations("Japan")
            if (searchedCountry == "Jordânia") showViewWithInformations("Jordan")
            if (searchedCountry == "Cazaquistão") showViewWithInformations("Kazakhstan")
            if (searchedCountry == "Quênia") showViewWithInformations("Kenya")
            if (searchedCountry == "Coréia do Sul") showViewWithInformations("South Korea")
            if (searchedCountry == "Kosovo") showViewWithInformations("Kosovo")
            if (searchedCountry == "Kuwait") showViewWithInformations("Kuwait")
            if (searchedCountry == "Quirguistão") showViewWithInformations("Kyrgyzstan")
            if (searchedCountry == "Laos") showViewWithInformations("Laos")
            if (searchedCountry == "Letônia") showViewWithInformations("Latvia")
            if (searchedCountry == "Líbano") showViewWithInformations("Lebanon")
            if (searchedCountry == "Lesoto") showViewWithInformations("Lesotho")
            if (searchedCountry == "Libéria") showViewWithInformations("Liberia")
            if (searchedCountry == "Líbia") showViewWithInformations("Libya")
            if (searchedCountry == "Liechtenstein") showViewWithInformations("Liechtenstein")
            if (searchedCountry == "Lituânia") showViewWithInformations("Lithuania")
            if (searchedCountry == "Luxemburgo") showViewWithInformations("Luxembourg")
            if (searchedCountry == "Madagáscar") showViewWithInformations("Madagascar")
            if (searchedCountry == "Malawi") showViewWithInformations("Malawi")
            if (searchedCountry == "Malásia") showViewWithInformations("Malaysia")
            if (searchedCountry == "Maldivas") showViewWithInformations("Maldives")
            if (searchedCountry == "Mali") showViewWithInformations("Mali")
            if (searchedCountry == "Malta") showViewWithInformations("Malta")
            if (searchedCountry == "Mauritânia") showViewWithInformations("Mauritania")
            if (searchedCountry == "Maurícia") showViewWithInformations("Mauritius")
            if (searchedCountry == "México") showViewWithInformations("Mexico")
            if (searchedCountry == "Moldova") showViewWithInformations("Moldova")
            if (searchedCountry == "Mônaco") showViewWithInformations("Monaco")
            if (searchedCountry == "Mongólia") showViewWithInformations("Mongolia")
            if (searchedCountry == "Montenegro") showViewWithInformations("Montenegro")
            if (searchedCountry == "Marrocos") showViewWithInformations("Morocco")
            if (searchedCountry == "Moçambique") showViewWithInformations("Mozambique")
            if (searchedCountry == "Namibia") showViewWithInformations("Namibia")
            if (searchedCountry == "Nepal") showViewWithInformations("Nepal")
            if (searchedCountry == "Países Baixos") showViewWithInformations("Netherlands")
            if (searchedCountry == "Nova Zelândia") showViewWithInformations("New Zealand")
            if (searchedCountry == "Nicarágua") showViewWithInformations("Nicaragua")
            if (searchedCountry == "Níger") showViewWithInformations("Niger")
            if (searchedCountry == "Nigéria") showViewWithInformations("Nigeria")
            if (searchedCountry == "Macedônia do Norte") showViewWithInformations(
                "North Macedonia"
            )
            if (searchedCountry == "Noruega") showViewWithInformations("Norway")
            if (searchedCountry == "Omã") showViewWithInformations("Oman")
            if (searchedCountry == "Paquistão") showViewWithInformations("Pakistan")
            if (searchedCountry == "Panamá") showViewWithInformations("Panama")
            if (searchedCountry == "Papua Nova Guiné") showViewWithInformations(
                "Papua New Guinea"
            )
            if (searchedCountry == "Paraguai") showViewWithInformations("Paraguay")
            if (searchedCountry == "Peru") showViewWithInformations("Peru")
            if (searchedCountry == "Filipinas") showViewWithInformations("Philippines")
            if (searchedCountry == "Polônia") showViewWithInformations("Poland")
            if (searchedCountry == "Portugal") showViewWithInformations("Portugal")
            if (searchedCountry == "Catar") showViewWithInformations("Qatar")
            if (searchedCountry == "Romênia") showViewWithInformations("Romania")
            if (searchedCountry == "Rússia") showViewWithInformations("Russia")
            if (searchedCountry == "Ruanda") showViewWithInformations("Rwanda")
            if (searchedCountry == "São Cristóvão e Neves") showViewWithInformations(
                "Saint Kitts and Nevis"
            )
            if (searchedCountry == "Santa Lúcia") showViewWithInformations("Saint Lucia")
            if (searchedCountry == "São Vicente e Granadinas") showViewWithInformations(
                "Saint Vincent and the Grenadines"
            )
            if (searchedCountry == "San Marino") showViewWithInformations("San Marino")
            if (searchedCountry == "São Tomé e Príncipe") showViewWithInformations(
                "Sao Tome and Principe"
            )
            if (searchedCountry == "Senegal") showViewWithInformations("Senegal")
            if (searchedCountry == "Sérvia") showViewWithInformations("Serbia")
            if (searchedCountry == "Seicheles") showViewWithInformations("Seychelles")
            if (searchedCountry == "Serra Leoa") showViewWithInformations("Sierra Leone")
            if (searchedCountry == "Cingapura") showViewWithInformations("Singapore")
            if (searchedCountry == "Eslováquia") showViewWithInformations("Slovakia")
            if (searchedCountry == "Eslovênia") showViewWithInformations("Slovenia")
            if (searchedCountry == "Somália") showViewWithInformations("Somalia")
            if (searchedCountry == "África do Sul") showViewWithInformations("South Africa")
            if (searchedCountry == "Sudão do Sul") showViewWithInformations("Southern Sudan")
            if (searchedCountry == "Espanha") showViewWithInformations("Spain")
            if (searchedCountry == "Sri Lanka") showViewWithInformations("Sri Lanka")
            if (searchedCountry == "Sudão") showViewWithInformations("Sudan")
            if (searchedCountry == "Suriname") showViewWithInformations("Suriname")
            if (searchedCountry == "Suécia") showViewWithInformations("Sweden")
            if (searchedCountry == "Suíça") showViewWithInformations("Sweden")
            if (searchedCountry == "Síria") showViewWithInformations("Syria")
            if (searchedCountry == "Taiwan") showViewWithInformations("Taiwan")
            if (searchedCountry == "Tajiquistão") showViewWithInformations("Tajikistan")
            if (searchedCountry == "Tanzânia") showViewWithInformations("Tanzania")
            if (searchedCountry == "Timor-Leste") showViewWithInformations("Timor-Leste")
            if (searchedCountry == "Togo") showViewWithInformations("Togo")
            if (searchedCountry == "Trinidade e Tobago") showViewWithInformations(
                "Trinidad and Tobago"
            )
            if (searchedCountry == "Tunísia") showViewWithInformations("Tunisia")
            if (searchedCountry == "Turquia") showViewWithInformations("Turkey")
            if (searchedCountry == "Estados Unidos") showViewWithInformations("us")
            if (searchedCountry == "Uganda") showViewWithInformations("Uganda")
            if (searchedCountry == "Ucrânia") showViewWithInformations("Ukraine")
            if (searchedCountry == "Emirados Árabes Unidos") showViewWithInformations(
                "United Arab Emirates"
            )
            if (searchedCountry == "Reino Unido") showViewWithInformations("United Kingdom")
            if (searchedCountry == "Uruguai") showViewWithInformations("Uruguay")
            if (searchedCountry == "Uzbequistão") showViewWithInformations("Uzbekistan")
            if (searchedCountry == "Venezuela") showViewWithInformations("Venezuela")
            if (searchedCountry == "Vietnã") showViewWithInformations("Vietnam")
            if (searchedCountry == "Cisjordânia e Gaza") showViewWithInformations(
                "West Bank and Gaza"
            )
            if (searchedCountry == "Saara Ocidental") showViewWithInformations("Western Sahara")
            if (searchedCountry == "Iémen") showViewWithInformations("Yemen")
            if (searchedCountry == "Zâmbia") showViewWithInformations("Zambia")
            if (searchedCountry == "Zimbábue") showViewWithInformations("Zimbabwe")
        }
    }

    @SuppressLint("LongLogTag")
    private fun showViewWithInformations(countryName: String) {
        val progressDialog = ProgressDialog(activity, R.style.alertDialogStyle)
        progressDialog.setMessage("Aguarde...")

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
                            Log.e("Error in specific state request ", resource.message.toString())
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