package com.example.zapiskz.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.zapiskz.data.api.ThePlaceDBInterface
import com.example.zapiskz.data.vo.PlaceDetails
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PlaceDetailsNetworkDataSource(private val apiService:ThePlaceDBInterface, private val compositeDisposable: CompositeDisposable) {

    private val _networkState  = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
        get() = _networkState
    private val _downloadedPlaceDetailsResponse = MutableLiveData<PlaceDetails>()
    val downloadedPlaceResponse:LiveData<PlaceDetails>
        get() = _downloadedPlaceDetailsResponse

    fun fetchPlaceDetails(placeId:Int) {
        _networkState.postValue(NetworkState.LOADING)

        try {
            compositeDisposable.add(
                apiService.getPlaceDetails(placeId)
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {
                            _downloadedPlaceDetailsResponse.postValue(it)
                            _networkState.postValue(NetworkState.LOADED)

                        },
                        {
                            _networkState.postValue(NetworkState.ERROR)
                            Log.e("PlaceDetailsDataSource", it.message )
                        }
                    )
            )
        }
        catch(e:Exception) {
                Log.e("PlaceDetailsDataSource", e.message)
        }
    }
}