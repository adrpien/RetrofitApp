package com.adrpien.retrofitapp

import com.adrpien.retrofitapp.photos.Photos
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

/*
This interface
intefejs udostpeniajcacy metode wysyląjacą konkretne żądania pod ponkretne adresy
 */

interface PicsumService {

    @GET("/v2/list")
    fun getPhotosAsync(): Deferred<Response<Photos>>

}