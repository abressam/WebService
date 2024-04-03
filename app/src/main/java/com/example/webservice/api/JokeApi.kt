package com.example.webservice.api

import com.example.webservice.model.JokeResponse
import retrofit2.http.GET

internal interface JokeApi {

    @GET("/")
    suspend fun getRandomJoke(): JokeResponse
}