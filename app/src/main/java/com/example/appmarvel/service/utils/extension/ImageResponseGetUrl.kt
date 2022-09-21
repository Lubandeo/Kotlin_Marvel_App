package com.example.appmarvel.service.utils.extension

import com.example.appmarvel.service.response.ImageResponse
import com.example.appmarvel.service.utils.Constants.DOT

fun ImageResponse.getURL(): String {
    return "${this.path}$DOT${this.extension}"
}
