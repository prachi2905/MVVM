package com.data.assignment

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.data.assignment.Model.UserData
import com.retrofit1.Clients.APIClient
import com.retrofit1.Interfaces.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(application: Application) : AndroidViewModel(application) {
    var dataList: List<UserData> = ArrayList()
    private val mutableList: MutableLiveData<List<UserData>> = MutableLiveData()

    fun getProjectList(): LiveData<List<UserData>>? {
        val apiService = APIClient.client.create(ApiInterface::class.java)
        val call = apiService.getProjectList()

        call.enqueue(object : Callback<List<UserData>> {
            override fun onResponse(call: Call<List<UserData>>, response: Response<List<UserData>>) {
                Log.e("Response", response.message())
                val jsonResponse = response.body()
                dataList = jsonResponse as List<UserData>
                mutableList.postValue(dataList)
            }
            override fun onFailure(call: Call<List<UserData>>?, t: Throwable?) {
                Log.d("ERROR : ", " ")
            }
        })

        return mutableList


    }
}

