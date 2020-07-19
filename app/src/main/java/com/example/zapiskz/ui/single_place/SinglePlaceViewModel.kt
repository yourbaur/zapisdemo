package com.example.zapiskz.ui.single_place

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.zapiskz.data.repository.NetworkState
import com.example.zapiskz.data.vo.PlaceDetails
import io.reactivex.disposables.CompositeDisposable

class SinglePlaceViewModel(private val placeRepository:PlaceDetailsRepository, placeId:Int): ViewModel(){
    private val compositeDisposable = CompositeDisposable()

    val placeDetails: LiveData<PlaceDetails> by lazy {
        placeRepository.fetchingSinglePlaceDetails(compositeDisposable, placeId)
    }

    val networkState:LiveData<NetworkState> by lazy {
        placeRepository.getMovieDetailsNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}