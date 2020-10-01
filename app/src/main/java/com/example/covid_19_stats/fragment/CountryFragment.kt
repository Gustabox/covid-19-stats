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
import com.example.covid_19_stats.R
import com.example.covid_19_stats.model.country.Data
import com.example.covid_19_stats.util.resource.Status
import com.example.covid_19_stats.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_country.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CountryFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var autoCompleteCountry: AutoCompleteTextView
    private lateinit var buttonSearchCountry: Button

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
            if (autoCompleteCountry.text.toString() == "Afeganistão") showViewWithInformations("Afghanistan")
            if (autoCompleteCountry.text.toString() == "Albânia") showViewWithInformations("Albania")
            if (autoCompleteCountry.text.toString() == "Argélia") showViewWithInformations("Algeria")
            if (autoCompleteCountry.text.toString() == "Angola") showViewWithInformations("Angola")
            if (autoCompleteCountry.text.toString() == "Antigua e Barbuda") showViewWithInformations(
                "Antigua and Barbuda"
            )
            if (autoCompleteCountry.text.toString() == "Argentina") showViewWithInformations("Argentina")
            if (autoCompleteCountry.text.toString() == "Armênia") showViewWithInformations("Armenia")
            if (autoCompleteCountry.text.toString() == "Austrália") showViewWithInformations("Australia")
            if (autoCompleteCountry.text.toString() == "Áustria") showViewWithInformations("Austria")
            if (autoCompleteCountry.text.toString() == "Azerbaijão") showViewWithInformations("Azerbaijan")
            if (autoCompleteCountry.text.toString() == "Bahamas") showViewWithInformations("Bahamas")
            if (autoCompleteCountry.text.toString() == "Bahrain") showViewWithInformations("Bahrain")
            if (autoCompleteCountry.text.toString() == "Bangladesh") showViewWithInformations("Bangladesh")
            if (autoCompleteCountry.text.toString() == "Barbadás") showViewWithInformations("Barbados")
            if (autoCompleteCountry.text.toString() == "Bielorrússia") showViewWithInformations("Belarus")
            if (autoCompleteCountry.text.toString() == "Bélgica") showViewWithInformations("Belgium")
            if (autoCompleteCountry.text.toString() == "Benin") showViewWithInformations("Benin")
            if (autoCompleteCountry.text.toString() == "Butão") showViewWithInformations("Bhutan")
            if (autoCompleteCountry.text.toString() == "Bolívia") showViewWithInformations("Bolivia")
            if (autoCompleteCountry.text.toString() == "Bósnia e Herzegovina") showViewWithInformations(
                "Bosnia and Herzegovina"
            )
            if (autoCompleteCountry.text.toString() == "Botsuana") showViewWithInformations("Botswana")
            if (autoCompleteCountry.text.toString() == "Brasil") showViewWithInformations("Brazil")
            if (autoCompleteCountry.text.toString() == "Brunei") showViewWithInformations("Brunei")
            if (autoCompleteCountry.text.toString() == "Bulgária") showViewWithInformations("Bulgaria")
            if (autoCompleteCountry.text.toString() == "Burkina Faso") showViewWithInformations("Burkina Faso")
            if (autoCompleteCountry.text.toString() == "Birmânia") showViewWithInformations("Burma")
            if (autoCompleteCountry.text.toString() == "Burundi") showViewWithInformations("Burundi")
            if (autoCompleteCountry.text.toString() == "Cabo Verde") showViewWithInformations("Cabo Verde")
            if (autoCompleteCountry.text.toString() == "Camboja") showViewWithInformations("Cambodia")
            if (autoCompleteCountry.text.toString() == "Camarões") showViewWithInformations("Cameroon")
            if (autoCompleteCountry.text.toString() == "Canadá") showViewWithInformations("Canada")
            if (autoCompleteCountry.text.toString() == "República Centro-Africana") showViewWithInformations(
                "Central African Republic"
            )
            if (autoCompleteCountry.text.toString() == "Chade") showViewWithInformations("Chad")
            if (autoCompleteCountry.text.toString() == "Chile") showViewWithInformations("Chile")
            if (autoCompleteCountry.text.toString() == "China") showViewWithInformations("China")
            if (autoCompleteCountry.text.toString() == "Colômbia") showViewWithInformations("Colombia")
            if (autoCompleteCountry.text.toString() == "Comores") showViewWithInformations("Comoros")
            if (autoCompleteCountry.text.toString() == "Costa Rica") showViewWithInformations("Costa Rica")
            if (autoCompleteCountry.text.toString() == "Costa do Marfim") showViewWithInformations("Costa do Marfim")
            if (autoCompleteCountry.text.toString() == "Croácia") showViewWithInformations("Croatia")
            if (autoCompleteCountry.text.toString() == "Cuba") showViewWithInformations("Cuba")
            if (autoCompleteCountry.text.toString() == "Chipre") showViewWithInformations("Cyprus")
            if (autoCompleteCountry.text.toString() == "Tchéquia") showViewWithInformations("Czechia")
            if (autoCompleteCountry.text.toString() == "Dinamarca") showViewWithInformations("Denmark")
            if (autoCompleteCountry.text.toString() == "Djibouti") showViewWithInformations("Djibouti")
            if (autoCompleteCountry.text.toString() == "Dominica") showViewWithInformations("Dominica")
            if (autoCompleteCountry.text.toString() == "República Dominicana") showViewWithInformations(
                "Dominican Republic"
            )
            if (autoCompleteCountry.text.toString() == "Equador") showViewWithInformations("Ecuador")
            if (autoCompleteCountry.text.toString() == "Egito") showViewWithInformations("Egypt")
            if (autoCompleteCountry.text.toString() == "El Salvador") showViewWithInformations("El Salvador")
            if (autoCompleteCountry.text.toString() == "Guiné Equatorial") showViewWithInformations(
                "Equatorial Guinea"
            )
            if (autoCompleteCountry.text.toString() == "Eritreia") showViewWithInformations("Eritrea")
            if (autoCompleteCountry.text.toString() == "Estônia") showViewWithInformations("Estonia")
            if (autoCompleteCountry.text.toString() == "Suazilândia") showViewWithInformations("Swaziland")
            if (autoCompleteCountry.text.toString() == "Etiópia") showViewWithInformations("Ethiopia")
            if (autoCompleteCountry.text.toString() == "Fiji") showViewWithInformations("Fiji")
            if (autoCompleteCountry.text.toString() == "Finlândia") showViewWithInformations("Finland")
            if (autoCompleteCountry.text.toString() == "França") showViewWithInformations("France")
            if (autoCompleteCountry.text.toString() == "Gabão") showViewWithInformations("Gabon")
            if (autoCompleteCountry.text.toString() == "Georgia") showViewWithInformations("Georgia")
            if (autoCompleteCountry.text.toString() == "Alemanha") showViewWithInformations("Germany")
            if (autoCompleteCountry.text.toString() == "Gana") showViewWithInformations("Ghana")
            if (autoCompleteCountry.text.toString() == "Grécia") showViewWithInformations("Greece")
            if (autoCompleteCountry.text.toString() == "Grenada") showViewWithInformations("Grenada")
            if (autoCompleteCountry.text.toString() == "Guatemala") showViewWithInformations("Guatemala")
            if (autoCompleteCountry.text.toString() == "Guiné") showViewWithInformations("Guinea")
            if (autoCompleteCountry.text.toString() == "Guiné-Bissau") showViewWithInformations("Guinea Bissau")
            if (autoCompleteCountry.text.toString() == "Guiana") showViewWithInformations("Guyana")
            if (autoCompleteCountry.text.toString() == "Haiti") showViewWithInformations("Haiti")
            if (autoCompleteCountry.text.toString() == "Santa Sé") showViewWithInformations("Holy See")
            if (autoCompleteCountry.text.toString() == "Honduras") showViewWithInformations("Honduras")
            if (autoCompleteCountry.text.toString() == "Hungria") showViewWithInformations("Hungary")
            if (autoCompleteCountry.text.toString() == "Islândia") showViewWithInformations("Iceland")
            if (autoCompleteCountry.text.toString() == "Índia") showViewWithInformations("India")
            if (autoCompleteCountry.text.toString() == "Indonésia") showViewWithInformations("Indonesia")
            if (autoCompleteCountry.text.toString() == "Irã") showViewWithInformations("Iran")
            if (autoCompleteCountry.text.toString() == "Iraque") showViewWithInformations("Iraq")
            if (autoCompleteCountry.text.toString() == "Irlanda") showViewWithInformations("Ireland")
            if (autoCompleteCountry.text.toString() == "Israel") showViewWithInformations("Israel")
            if (autoCompleteCountry.text.toString() == "Itália") showViewWithInformations("Italy")
            if (autoCompleteCountry.text.toString() == "Jamaica") showViewWithInformations("Jamaica")
            if (autoCompleteCountry.text.toString() == "Japão") showViewWithInformations("Japan")
            if (autoCompleteCountry.text.toString() == "Jordânia") showViewWithInformations("Jordan")
            if (autoCompleteCountry.text.toString() == "Cazaquistão") showViewWithInformations("Kazakhstan")
            if (autoCompleteCountry.text.toString() == "Quênia") showViewWithInformations("Kenya")
            if (autoCompleteCountry.text.toString() == "Coréia do Sul") showViewWithInformations("South Korea")
            if (autoCompleteCountry.text.toString() == "Kosovo") showViewWithInformations("Kosovo")
            if (autoCompleteCountry.text.toString() == "Kuwait") showViewWithInformations("Kuwait")
            if (autoCompleteCountry.text.toString() == "Quirguistão") showViewWithInformations("Kyrgyzstan")
            if (autoCompleteCountry.text.toString() == "Laos") showViewWithInformations("Laos")
            if (autoCompleteCountry.text.toString() == "Letônia") showViewWithInformations("Latvia")
            if (autoCompleteCountry.text.toString() == "Líbano") showViewWithInformations("Lebanon")
            if (autoCompleteCountry.text.toString() == "Lesoto") showViewWithInformations("Lesotho")
            if (autoCompleteCountry.text.toString() == "Libéria") showViewWithInformations("Liberia")
            if (autoCompleteCountry.text.toString() == "Líbia") showViewWithInformations("Libya")
            if (autoCompleteCountry.text.toString() == "Liechtenstein") showViewWithInformations("Liechtenstein")
            if (autoCompleteCountry.text.toString() == "Lituânia") showViewWithInformations("Lithuania")
            if (autoCompleteCountry.text.toString() == "Luxemburgo") showViewWithInformations("Luxembourg")
            if (autoCompleteCountry.text.toString() == "Madagáscar") showViewWithInformations("Madagascar")
            if (autoCompleteCountry.text.toString() == "Malawi") showViewWithInformations("Malawi")
            if (autoCompleteCountry.text.toString() == "Malásia") showViewWithInformations("Malaysia")
            if (autoCompleteCountry.text.toString() == "Maldivas") showViewWithInformations("Maldives")
            if (autoCompleteCountry.text.toString() == "Mali") showViewWithInformations("Mali")
            if (autoCompleteCountry.text.toString() == "Malta") showViewWithInformations("Malta")
            if (autoCompleteCountry.text.toString() == "Mauritânia") showViewWithInformations("Mauritania")
            if (autoCompleteCountry.text.toString() == "Maurícia") showViewWithInformations("Mauritius")
            if (autoCompleteCountry.text.toString() == "México") showViewWithInformations("Mexico")
            if (autoCompleteCountry.text.toString() == "Moldova") showViewWithInformations("Moldova")
            if (autoCompleteCountry.text.toString() == "Mônaco") showViewWithInformations("Monaco")
            if (autoCompleteCountry.text.toString() == "Mongólia") showViewWithInformations("Mongolia")
            if (autoCompleteCountry.text.toString() == "Montenegro") showViewWithInformations("Montenegro")
            if (autoCompleteCountry.text.toString() == "Marrocos") showViewWithInformations("Morocco")
            if (autoCompleteCountry.text.toString() == "Moçambique") showViewWithInformations("Mozambique")
            if (autoCompleteCountry.text.toString() == "Namibia") showViewWithInformations("Namibia")
            if (autoCompleteCountry.text.toString() == "Nepal") showViewWithInformations("Nepal")
            if (autoCompleteCountry.text.toString() == "Países Baixos") showViewWithInformations("Netherlands")
            if (autoCompleteCountry.text.toString() == "Nova Zelândia") showViewWithInformations("New Zealand")
            if (autoCompleteCountry.text.toString() == "Nicarágua") showViewWithInformations("Nicaragua")
            if (autoCompleteCountry.text.toString() == "Níger") showViewWithInformations("Niger")
            if (autoCompleteCountry.text.toString() == "Nigéria") showViewWithInformations("Nigeria")
            if (autoCompleteCountry.text.toString() == "Macedônia do Norte") showViewWithInformations(
                "North Macedonia"
            )
            if (autoCompleteCountry.text.toString() == "Noruega") showViewWithInformations("Norway")
            if (autoCompleteCountry.text.toString() == "Omã") showViewWithInformations("Oman")
            if (autoCompleteCountry.text.toString() == "Paquistão") showViewWithInformations("Pakistan")
            if (autoCompleteCountry.text.toString() == "Panamá") showViewWithInformations("Panama")
            if (autoCompleteCountry.text.toString() == "Papua Nova Guiné") showViewWithInformations(
                "Papua New Guinea"
            )
            if (autoCompleteCountry.text.toString() == "Paraguai") showViewWithInformations("Paraguay")
            if (autoCompleteCountry.text.toString() == "Peru") showViewWithInformations("Peru")
            if (autoCompleteCountry.text.toString() == "Filipinas") showViewWithInformations("Philippines")
            if (autoCompleteCountry.text.toString() == "Polônia") showViewWithInformations("Poland")
            if (autoCompleteCountry.text.toString() == "Portugal") showViewWithInformations("Portugal")
            if (autoCompleteCountry.text.toString() == "Catar") showViewWithInformations("Qatar")
            if (autoCompleteCountry.text.toString() == "Romênia") showViewWithInformations("Romania")
            if (autoCompleteCountry.text.toString() == "Rússia") showViewWithInformations("Russia")
            if (autoCompleteCountry.text.toString() == "Ruanda") showViewWithInformations("Rwanda")
            if (autoCompleteCountry.text.toString() == "São Cristóvão e Neves") showViewWithInformations(
                "Saint Kitts and Nevis"
            )
            if (autoCompleteCountry.text.toString() == "Santa Lúcia") showViewWithInformations("Saint Lucia")
            if (autoCompleteCountry.text.toString() == "São Vicente e Granadinas") showViewWithInformations(
                "Saint Vincent and the Grenadines"
            )
            if (autoCompleteCountry.text.toString() == "San Marino") showViewWithInformations("San Marino")
            if (autoCompleteCountry.text.toString() == "São Tomé e Príncipe") showViewWithInformations(
                "Sao Tome and Principe"
            )
            if (autoCompleteCountry.text.toString() == "Senegal") showViewWithInformations("Senegal")
            if (autoCompleteCountry.text.toString() == "Sérvia") showViewWithInformations("Serbia")
            if (autoCompleteCountry.text.toString() == "Seicheles") showViewWithInformations("Seychelles")
            if (autoCompleteCountry.text.toString() == "Serra Leoa") showViewWithInformations("Sierra Leone")
            if (autoCompleteCountry.text.toString() == "Cingapura") showViewWithInformations("Singapore")
            if (autoCompleteCountry.text.toString() == "Eslováquia") showViewWithInformations("Slovakia")
            if (autoCompleteCountry.text.toString() == "Eslovênia") showViewWithInformations("Slovenia")
            if (autoCompleteCountry.text.toString() == "Somália") showViewWithInformations("Somalia")
            if (autoCompleteCountry.text.toString() == "África do Sul") showViewWithInformations("South Africa")
            if (autoCompleteCountry.text.toString() == "Sudão do Sul") showViewWithInformations("Southern Sudan")
            if (autoCompleteCountry.text.toString() == "Espanha") showViewWithInformations("Spain")
            if (autoCompleteCountry.text.toString() == "Sri Lanka") showViewWithInformations("Sri Lanka")
            if (autoCompleteCountry.text.toString() == "Sudão") showViewWithInformations("Sudan")
            if (autoCompleteCountry.text.toString() == "Suriname") showViewWithInformations("Suriname")
            if (autoCompleteCountry.text.toString() == "Suécia") showViewWithInformations("Sweden")
            if (autoCompleteCountry.text.toString() == "Suíça") showViewWithInformations("Sweden")
            if (autoCompleteCountry.text.toString() == "Síria") showViewWithInformations("Syria")
            if (autoCompleteCountry.text.toString() == "Taiwan") showViewWithInformations("Taiwan")
            if (autoCompleteCountry.text.toString() == "Tajiquistão") showViewWithInformations("Tajikistan")
            if (autoCompleteCountry.text.toString() == "Tanzânia") showViewWithInformations("Tanzania")
            if (autoCompleteCountry.text.toString() == "Timor-Leste") showViewWithInformations("Timor-Leste")
            if (autoCompleteCountry.text.toString() == "Togo") showViewWithInformations("Togo")
            if (autoCompleteCountry.text.toString() == "Trinidade e Tobago") showViewWithInformations(
                "Trinidad and Tobago"
            )
            if (autoCompleteCountry.text.toString() == "Tunísia") showViewWithInformations("Tunisia")
            if (autoCompleteCountry.text.toString() == "Turquia") showViewWithInformations("Turkey")
            if (autoCompleteCountry.text.toString() == "Estados Unidos") showViewWithInformations("us")
            if (autoCompleteCountry.text.toString() == "Uganda") showViewWithInformations("Uganda")
            if (autoCompleteCountry.text.toString() == "Ucrânia") showViewWithInformations("Ukraine")
            if (autoCompleteCountry.text.toString() == "Emirados Árabes Unidos") showViewWithInformations(
                "United Arab Emirates"
            )
            if (autoCompleteCountry.text.toString() == "Reino Unido") showViewWithInformations("United Kingdom")
            if (autoCompleteCountry.text.toString() == "Uruguai") showViewWithInformations("Uruguay")
            if (autoCompleteCountry.text.toString() == "Uzbequistão") showViewWithInformations("Uzbekistan")
            if (autoCompleteCountry.text.toString() == "Venezuela") showViewWithInformations("Venezuela")
            if (autoCompleteCountry.text.toString() == "Vietnã") showViewWithInformations("Vietnam")
            if (autoCompleteCountry.text.toString() == "Cisjordânia e Gaza") showViewWithInformations(
                "West Bank and Gaza"
            )
            if (autoCompleteCountry.text.toString() == "Saara Ocidental") showViewWithInformations("Western Sahara")
            if (autoCompleteCountry.text.toString() == "Iémen") showViewWithInformations("Yemen")
            if (autoCompleteCountry.text.toString() == "Zâmbia") showViewWithInformations("Zambia")
            if (autoCompleteCountry.text.toString() == "Zimbábue") showViewWithInformations("Zimbabwe")
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
    private fun getAllCountries(mainActivityViewModel: MainActivityViewModel) {
        mainActivityViewModel.getAllCountries().observe(this, androidx.lifecycle.Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.LOADING -> {
                        Log.d("Loading all countries request ", "loading...")
                    }
                    Status.SUCCESS -> {
                        resource.data?.let {
                            //TODO...
                        }!!
                    }
                    Status.ERROR -> {
                        Log.e("Error in all countries request ", resource.message.toString())
                    }
                }
            }
        })
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