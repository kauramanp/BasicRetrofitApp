package com.aman.basicretrofitapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClass {
    lateinit var  apiInterface: ApiInterface
    private lateinit var retrofit: Retrofit

    fun getApiClient(): ApiInterface {
        if (!this::retrofit.isInitialized) {
            retrofit = Retrofit.Builder()
                .baseUrl("https://gorest.co.in/public/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        apiInterface =  retrofit.create(ApiInterface::class.java)
        return apiInterface
    }
}