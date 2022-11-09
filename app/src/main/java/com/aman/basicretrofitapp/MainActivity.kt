package com.aman.basicretrofitapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.aman.basicretrofitapp.databinding.ActivityMainBinding
import com.aman.basicretrofitapp.models.Users
import com.aman.basicretrofitapp.recycler.RAUsers
import com.aman.basicretrofitapp.retrofit.RetrofitClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var usersList = arrayListOf<Users>()
    private val TAG = "MainActivity"
    lateinit var adapter: RAUsers
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = RAUsers(usersList)
        binding.rcUsers.layoutManager = LinearLayoutManager(this)
        binding.rcUsers.adapter  = adapter

        val call: Call<ArrayList<Users>> = RetrofitClass().getApiClient().getUsers()
            call.enqueue(object: Callback<ArrayList<Users>>{
                override fun onResponse(
                    call: Call<ArrayList<Users>>,
                    response: Response<ArrayList<Users>>
                ) {
                    usersList.addAll(response.body() as ArrayList<Users>)
                    adapter.notifyDataSetChanged()
                    Log.e(TAG, " in success")
                }

                override fun onFailure(call: Call<ArrayList<Users>>, t: Throwable) {
                    Log.e(TAG, " in failure")
                }
            })

        }
}