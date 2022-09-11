package com.example.appmarvel.service.api

import com.example.appmarvel.service.response.DataResponse
import retrofit2.Call
import retrofit2.http.GET

interface MarvelApi {

    @GET("v1/public/characters")
    fun getCharactersList(): Call<DataResponse>
}
