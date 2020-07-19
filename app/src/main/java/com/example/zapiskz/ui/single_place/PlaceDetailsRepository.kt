package com.example.zapiskz.ui.single_place

import android.net.Network
import androidx.lifecycle.LiveData
import com.example.zapiskz.data.api.ThePlaceDBInterface
import com.example.zapiskz.data.repository.NetworkState
import com.example.zapiskz.data.repository.PlaceDetailsNetworkDataSource
import com.example.zapiskz.data.vo.PlaceDetails
import io.reactivex.disposables.CompositeDisposable

class PlaceDetailsRepository(private val apiService:ThePlaceDBInterface) {
    lateinit var placeDetailsNetworkDataSource:PlaceDetailsNetworkDataSource

    fun fetchingSinglePlaceDetails(compositeDisposable: CompositeDisposable, placeId:Int) :LiveData<PlaceDetails> {

        placeDetailsNetworkDataSource = PlaceDetailsNetworkDataSource(apiService, compositeDisposable)
        placeDetailsNetworkDataSource.fetchPlaceDetails(placeId)

        return placeDetailsNetworkDataSource.downloadedPlaceResponse
    }

    fun getMovieDetailsNetworkState():LiveData<NetworkState> {
        return placeDetailsNetworkDataSource.networkState
    }

}