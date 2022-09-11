package com.example.appmarvel.service.response

import com.google.gson.annotations.SerializedName

class DataResponse(
    @SerializedName("data")
    val data: ResultResponse
)
