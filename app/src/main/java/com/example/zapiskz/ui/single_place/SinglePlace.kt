package com.example.zapiskz.ui.single_place

import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.zapiskz.R
import com.example.zapiskz.data.api.POSTER_BASE_URL
import com.example.zapiskz.data.api.ThePlaceDBClient
import com.example.zapiskz.data.api.ThePlaceDBInterface
import com.example.zapiskz.data.repository.NetworkState
import com.example.zapiskz.data.vo.PlaceDetails
import kotlinx.android.synthetic.main.single_place.*


class SinglePlace : AppCompatActivity() {
    private lateinit var viewModel:SinglePlaceViewModel
    private lateinit var placeRepository: PlaceDetailsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.single_place)

        val placeId:Int = intent.getIntExtra("id", 206)

        val apiService: ThePlaceDBInterface = ThePlaceDBClient.getClient()
        placeRepository = PlaceDetailsRepository(apiService)

        viewModel = getViewModel(placeId)

        viewModel.placeDetails.observe(this, Observer {
            bindUI(it)
        })
        viewModel.networkState.observe(this, Observer {
            progress_bar.visibility = if (it== NetworkState.LOADING) View.VISIBLE else View.GONE
            txt_error.visibility =if (it==NetworkState.ERROR) View.VISIBLE else View.GONE
        })
    }
    fun bindUI(it:PlaceDetails) {
        place_title.text = it.data.firm.name
        address.text = it.data.firm.address
        category.text = it.data.firm.category

        var services_text = ""
        var services = it.data.services
        for (service in services) {
            services_text += service.name + " " + service.priceStr + "\n"
        }
        place_service.text = services_text

        val placePosterURL = POSTER_BASE_URL + it.data.firm.avatarUrl

        Glide.with(this)
            .load(placePosterURL)
            .into(iv_place);


    }

    private fun getViewModel(placeId:Int):SinglePlaceViewModel {
        return ViewModelProviders.of(this, object:ViewModelProvider.Factory {
            override fun<T: ViewModel?> create(modelClass:Class<T>):T {
                return SinglePlaceViewModel(placeRepository, placeId) as T
            }
        })[SinglePlaceViewModel::class.java]
    }

}
