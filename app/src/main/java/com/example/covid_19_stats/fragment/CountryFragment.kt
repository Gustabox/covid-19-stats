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
            //TODO: CONSTANT
            if (autoCompleteCountry.text.toString() == "Afeganistão") showViewWithInformations("afghanistan")
            if (autoCompleteCountry.text.toString() == "Albânia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Argélia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Angola") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Antigua e Barbuda") showViewWithInformations(
                "albania"
            )
            if (autoCompleteCountry.text.toString() == "Argentina") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Armênia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Austrália") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Áustria") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Azerbaijão") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Bahamas") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Bahrain") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Bangladesh") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Barbadás") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Bielorrússia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Bélgica") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Benin") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Butão") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Bolívia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Bósnia e Herzegovina") showViewWithInformations(
                "albania"
            )
            if (autoCompleteCountry.text.toString() == "Botsuana") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Brasil") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Brunei") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Bulgária") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Burkina Faso") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Birmânia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Burundi") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Cabo Verde") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Camboja") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Camarões") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Canadá") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "República Centro-Africana") showViewWithInformations(
                "albania"
            )
            if (autoCompleteCountry.text.toString() == "Chade") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Chile") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "China") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Colômbia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Comores") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Costa Rica") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Costa do Marfim") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Croácia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Cuba") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Chipre") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Tchéquia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Dinamarca") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Djibouti") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Dominica") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "República Dominicana") showViewWithInformations(
                "albania"
            )
            if (autoCompleteCountry.text.toString() == "Equador") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Egito") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "El Salvador") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Guiné Equatorial") showViewWithInformations(
                "albania"
            )
            if (autoCompleteCountry.text.toString() == "Eritreia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Estônia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Suazilândia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Etiópia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Fiji") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Finlândia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "França") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Gabão") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Georgia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Alemanha") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Gana") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Grécia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Grenada") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Guatemala") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Guiné") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Guiné-Bissau") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Guiana") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Haiti") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Santa Sé") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Honduras") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Hungria") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Islândia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Índia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Indonésia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Irã") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Iraque") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Irlanda") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Israel") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Itália") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Jamaica") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Japão") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Jordânia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Cazaquistão") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Quênia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Coréia do Sul") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Kosovo") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Kuwait") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Quirguistão") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Laos") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Letônia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Líbano") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Lesoto") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Libéria") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Líbia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Liechtenstein") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Lituânia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Luxemburgo") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Madagáscar") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Malawi") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Malásia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Maldivas") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Mali") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Malta") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Mauritânia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Maurícia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "México") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Moldova") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Mônaco") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Mongólia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Montenegro") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Marrocos") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Moçambique") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Namibia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Nepal") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Países Baixos") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Nova Zelândia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Nicarágua") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Níger") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Nigéria") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Macedônia do Norte") showViewWithInformations(
                "albania"
            )
            if (autoCompleteCountry.text.toString() == "Noruega") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Omã") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Paquistão") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Panamá") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Papua Nova Guiné") showViewWithInformations(
                "albania"
            )
            if (autoCompleteCountry.text.toString() == "Paraguai") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Peru") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Filipinas") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Polônia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Portugal") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Catar") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Romênia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Rússia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Ruanda") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "São Cristóvão e Neves") showViewWithInformations(
                "albania"
            )
            if (autoCompleteCountry.text.toString() == "Santa Lúcia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "São Vicente e Granadinas") showViewWithInformations(
                "albania"
            )
            if (autoCompleteCountry.text.toString() == "San Marino") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "São Tomé e Príncipe") showViewWithInformations(
                "albania"
            )
            if (autoCompleteCountry.text.toString() == "Senegal") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Sérvia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Seicheles") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Serra Leoa") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Cingapura") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Eslováquia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Eslovênia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Somália") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "África do Sul") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Sudão do Sul") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Sudão do Sul") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Espanha") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Sri Lanka") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Sudão") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Suriname") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Suécia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Suíça") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Síria") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Taiwan") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Tajiquistão") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Tanzânia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Timor-Leste") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Togo") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Trinidade e Tobago") showViewWithInformations(
                "albania"
            )
            if (autoCompleteCountry.text.toString() == "Tunísia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Turquia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Estados Unidos") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Uganda") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Ucrânia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Emirados Árabes Unidos") showViewWithInformations(
                "albania"
            )
            if (autoCompleteCountry.text.toString() == "Reino Unido") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Uruguai") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Uzbequistão") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Venezuela") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Vietnã") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Cisjordânia e Gaza") showViewWithInformations(
                "albania"
            )
            if (autoCompleteCountry.text.toString() == "Saara Ocidental") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Iémen") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Zâmbia") showViewWithInformations("albania")
            if (autoCompleteCountry.text.toString() == "Zimbábue") showViewWithInformations("albania")
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