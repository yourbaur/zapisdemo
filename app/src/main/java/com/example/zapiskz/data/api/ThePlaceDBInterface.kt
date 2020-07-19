package com.example.zapiskz.data.api

import com.example.zapiskz.data.vo.PlaceDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ThePlaceDBInterface {
    //http://zp.jgroup.kz/rest/clients-app/v1/screen/home
    //http://zp.jgroup.kz/rest/clients-app/v1/firms/206
    //http://zp.jgroup.kz/
    @GET("rest/clients-app/v1/firms/{place_id}")
    fun getPlaceDetails(@Path("place_id") id:Int):Single<PlaceDetails>

}