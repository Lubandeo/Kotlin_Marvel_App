package com.example.appmarvel.service.serviceinterface

import com.example.appmarvel.entity.Character
import com.example.appmarvel.service.utils.Result

interface MarvelService {
    fun getCharactersList(): Result<List<Character>>
}
