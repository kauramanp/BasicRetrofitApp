package com.aman.basicretrofitapp.retrofit

import com.aman.basicretrofitapp.models.Users
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("users")
    fun getUsers():Call<ArrayList<Users>>
}