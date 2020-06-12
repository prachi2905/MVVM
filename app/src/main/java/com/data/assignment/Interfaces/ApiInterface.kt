package com.retrofit1.Interfaces

import com.data.assignment.Model.UserData
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    @GET("posts")
    fun getProjectList(): Call<List<UserData>>
}