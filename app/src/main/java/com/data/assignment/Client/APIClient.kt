package com.retrofit1.Clients

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    companion object {

        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        var retofit: Retrofit? = null

        val client: Retrofit
            get() {

                if (retofit == null) {
                    retofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
                return retofit!!
            }
    }
}